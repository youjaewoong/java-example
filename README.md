
# java-example
Java8 기능의 샘플 구성 프로젝트 입니다.
```
- compartor
   클래스에서 제공하는 comparing 메서드를 사용하면 원하는 정렬 기준을 람다식으로 표현하여 정렬을 쉽게 할 수 있다.
   
- enums
   apply 를 통한 enums 열거형을 조작합니다.
   
- function
  - bifunction : 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
  - binaryoperator : BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
 - consumer : 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
 - function : T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
 - predicate : T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
 - supplier : T 타입의 값을 제공하는 함수 인터페이스
 - unaryoperator : Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스

- interface : default 메소드를 확인합니다.

- method : Spliterator 메소드를 통한 데이터를 반씩 나누어 로직처리를 합니다.

- methodreference : instance method reference, new 객체 새로운 선언 방법을 확인합니다. 

- object : requireNonNull 메소드를 통한 exception 처리 합니다.

- optional : Optional<T> 클래스는 Integer나 Double 클래스처럼 'T'타입의 객체를 포장해 주는 래퍼 클래스(Wrapper class)입니다.

- stream : 스트림 API는 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기 위한 공통된 방법을 제공합니다.
```
