/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.io.Buf
import com.twitter.scrooge.{
  HasThriftStructCodec3,
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object CollectionId extends ThriftStructCodec3[CollectionId] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("CollectionId")
  val CollectionLongIdField = new TField("collectionLongId", TType.I64, 1)
  val CollectionLongIdFieldManifest = implicitly[Manifest[Long]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      CollectionLongIdField,
      false,
      true,
      CollectionLongIdFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: CollectionId): Unit = {
  }

  def withoutPassthroughFields(original: CollectionId): CollectionId =
    new Immutable(
      collectionLongId =
        {
          val field = original.collectionLongId
          field
        }
    )

  override def encode(_item: CollectionId, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  private[this] def lazyDecode(_iprot: LazyTProtocol): CollectionId = {

    var collectionLongId: Long = 0L
    var _got_collectionLongId = false

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I64 =>

                collectionLongId = readCollectionLongIdValue(_iprot)
                _got_collectionLongId = true
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'collectionLongId' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_collectionLongId) throw new TProtocolException("Required field 'collectionLongId' was not found in serialized data for struct CollectionId")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      collectionLongId,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): CollectionId =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[this] def eagerDecode(_iprot: TProtocol): CollectionId = {
    var collectionLongId: Long = 0L
    var _got_collectionLongId = false
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I64 =>
                collectionLongId = readCollectionLongIdValue(_iprot)
                _got_collectionLongId = true
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'collectionLongId' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_collectionLongId) throw new TProtocolException("Required field 'collectionLongId' was not found in serialized data for struct CollectionId")
    new Immutable(
      collectionLongId,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    collectionLongId: Long
  ): CollectionId =
    new Immutable(
      collectionLongId
    )

  def unapply(_item: CollectionId): _root_.scala.Option[Long] = _root_.scala.Some(_item.collectionLongId)


  @inline private def readCollectionLongIdValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeCollectionLongIdField(collectionLongId_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(CollectionLongIdField)
    writeCollectionLongIdValue(collectionLongId_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeCollectionLongIdValue(collectionLongId_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(collectionLongId_item)
  }


  object Immutable extends ThriftStructCodec3[CollectionId] {
    override def encode(_item: CollectionId, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): CollectionId = CollectionId.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[CollectionId] = CollectionId.metaData
  }

  /**
   * The default read-only implementation of CollectionId.  You typically should not need to
   * directly reference this class; instead, use the CollectionId.apply method to construct
   * new instances.
   */
  class Immutable(
      val collectionLongId: Long,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends CollectionId {
    def this(
      collectionLongId: Long
    ) = this(
      collectionLongId,
      Map.empty
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val collectionLongId: Long,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends CollectionId {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }


    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the CollectionId trait with additional state or
   * behavior and implement the read-only methods from CollectionId using an underlying
   * instance.
   */
  trait Proxy extends CollectionId {
    protected def _underlying_CollectionId: CollectionId
    override def collectionLongId: Long = _underlying_CollectionId.collectionLongId
    override def _passthroughFields = _underlying_CollectionId._passthroughFields
  }
}

/**
 * Prefer the companion object's [[com.twitter.scrooge.test.gold.thriftscala.CollectionId.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait CollectionId
  extends ThriftStruct
  with _root_.scala.Product1[Long]
  with HasThriftStructCodec3[CollectionId]
  with java.io.Serializable
{
  import CollectionId._

  def collectionLongId: Long

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = collectionLongId


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (true) {
                writeCollectionLongIdValue(collectionLongId, _oprot)
                _root_.scala.Some(CollectionId.CollectionLongIdField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): CollectionId = {
    var collectionLongId: Long = this.collectionLongId
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        collectionLongId = readCollectionLongIdValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      collectionLongId,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): CollectionId = {
    var collectionLongId: Long = this.collectionLongId

    _fieldId match {
      case 1 =>
        collectionLongId = 0L
      case _ =>
    }
    new Immutable(
      collectionLongId,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetCollectionLongId: CollectionId = unsetField(1)


  override def write(_oprot: TProtocol): Unit = {
    CollectionId.validate(this)
    _oprot.writeStructBegin(Struct)
    writeCollectionLongIdField(collectionLongId, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    collectionLongId: Long = this.collectionLongId,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): CollectionId =
    new Immutable(
      collectionLongId,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[CollectionId]

  private def _equals(x: CollectionId, y: CollectionId): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[CollectionId]) &&
      _passthroughFields == other.asInstanceOf[CollectionId]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 1

  override def productElement(n: Int): Any = n match {
    case 0 => this.collectionLongId
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "CollectionId"

  def _codec: ThriftStructCodec3[CollectionId] = CollectionId
}