namespace java com.twitter.scripted
#@namespace scala com.twitter.scripted.thrift

struct Person {
  1: i64 id
  2: string name
}

service PersonService {
  Person findPerson(1: i64 id)
}
