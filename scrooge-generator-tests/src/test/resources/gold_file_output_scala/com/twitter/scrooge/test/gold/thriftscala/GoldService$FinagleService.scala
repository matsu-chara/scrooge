/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.finagle.Thrift
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.scrooge.{TReusableBuffer, ThriftStruct}
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, HashMap => mutable$HashMap}
import scala.collection.{Map, Set}

import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class GoldService$FinagleService(
  iface: GoldService[Future],
  protocolFactory: TProtocolFactory,
  stats: StatsReceiver,
  maxThriftBufferSize: Int,
  serviceName: String
) extends com.twitter.finagle.Service[Array[Byte], Array[Byte]] {
  import GoldService._

  def this(
    iface: GoldService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver,
    maxThriftBufferSize: Int
  ) = this(iface, protocolFactory, stats, maxThriftBufferSize, "GoldService")

  def this(
    iface: GoldService[Future],
    protocolFactory: TProtocolFactory
  ) = this(iface, protocolFactory, NullStatsReceiver, Thrift.maxThriftBufferSize)

  private[this] val tlReusableBuffer = TReusableBuffer()

  protected val functionMap = new mutable$HashMap[String, (TProtocol, Int) => Future[Array[Byte]]]()

  protected def addFunction(name: String, f: (TProtocol, Int) => Future[Array[Byte]]): Unit = {
    functionMap(name) = f
  }

  protected def exception(name: String, seqid: Int, code: Int, message: String): Future[Array[Byte]] = {
    try {
      val x = new TApplicationException(code, message)
      val memoryBuffer = tlReusableBuffer.get()
      try {
        val oprot = protocolFactory.getProtocol(memoryBuffer)

        oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
        x.write(oprot)
        oprot.writeMessageEnd()
        oprot.getTransport().flush()
        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } finally {
        tlReusableBuffer.reset()
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  protected def reply(name: String, seqid: Int, result: ThriftStruct): Future[Array[Byte]] = {
    try {
      val memoryBuffer = tlReusableBuffer.get()
      try {
        val oprot = protocolFactory.getProtocol(memoryBuffer)

        oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
        result.write(oprot)
        oprot.writeMessageEnd()

        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } finally {
        tlReusableBuffer.reset()
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  final def apply(request: Array[Byte]): Future[Array[Byte]] = {
    val inputTransport = new TMemoryInputTransport(request)
    val iprot = protocolFactory.getProtocol(inputTransport)

    try {
      val msg = iprot.readMessageBegin()
      val func = functionMap.get(msg.name)
      func match {
        case _root_.scala.Some(fn) =>
          fn(iprot, msg.seqid)
        case _ =>
          TProtocolUtil.skip(iprot, TType.STRUCT)
          exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
            "Invalid method name: '" + msg.name + "'")
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  // ---- end boilerplate.

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_doGreatThings {
    val RequestsCounter = scopedStats.scope("doGreatThings").counter("requests")
    val SuccessCounter = scopedStats.scope("doGreatThings").counter("success")
    val FailuresCounter = scopedStats.scope("doGreatThings").counter("failures")
    val FailuresScope = scopedStats.scope("doGreatThings").scope("failures")
  }
  addFunction("doGreatThings", { (iprot: TProtocol, seqid: Int) =>
    try {
      __stats_doGreatThings.RequestsCounter.incr()
      val args = DoGreatThings.Args.decode(iprot)
      iprot.readMessageEnd()
      (try {
        iface.doGreatThings(args.request)
      } catch {
        case e: Exception => Future.exception(e)
      }).flatMap { value: com.twitter.scrooge.test.gold.thriftscala.Response =>
        reply("doGreatThings", seqid, DoGreatThings.Result(success = Some(value)))
      }.rescue {
        case e: com.twitter.scrooge.test.gold.thriftscala.OverCapacityException => {
          reply("doGreatThings", seqid, DoGreatThings.Result(ex = Some(e)))
        }
        case e => Future.exception(e)
      }.respond {
        case Return(_) =>
          __stats_doGreatThings.SuccessCounter.incr()
        case Throw(ex) =>
          __stats_doGreatThings.FailuresCounter.incr()
          __stats_doGreatThings.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
      }
    } catch {
      case e: TProtocolException => {
        iprot.readMessageEnd()
        exception("doGreatThings", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
      }
      case e: Exception => Future.exception(e)
    }
  })
}
