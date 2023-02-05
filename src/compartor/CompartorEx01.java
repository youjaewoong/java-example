package compartor;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator 클래스에서 제공하는 comparing 메서드를 사용하면 원하는 정렬 기준을 람다식으로 표현하여 정렬을 쉽게 할 수 있다.
 * 정렬 기준이 되는 속성은 Comparable 타입이어야 한다. 여기서 Member의 age는 Integer이다.
 */
public class CompartorEx01 {

	public static void main(String[] args) {

		List<Member> memberList1 = Arrays.asList(Member.of(10), Member.of(5), Member.of(20));
		System.out.println(memberList1.size());
		List<Member> sortedMemberList1 = memberList1.stream()
				.sorted(Comparator.comparing(Member::getAge)) // age 속성 기준으로 정렬한다.
				.collect(toList());
		System.out.println("기본정렬");
		System.out.println(sortedMemberList1);

		// 역순정렬
		List<Member> memberList2 = Arrays.asList(Member.of(10), Member.of(5), Member.of(20));
		List<Member> sortedMemberList2 = memberList2.stream()
				.sorted(Comparator.comparing(Member::getAge, Comparator.reverseOrder()))
				.collect(toList());
		System.out.println("역순정렬 Comparator.reverseOrder()");
		System.out.println(sortedMemberList2);

		// null을 가진 객체를 앞으로 보낸다.
		List<Member> memberList3 = Arrays.asList(Member.of(10), Member.of(null), Member.of(5));
		List<Member> result1 = memberList3.stream()
				.sorted(Comparator.comparing(Member::getAge, Comparator.nullsLast(Comparator.naturalOrder())))
				.collect(toList());
		System.out.println("null을 가진 객체를 앞으로 보낸다. Comparator.nullsLast(Comparator.naturalOrder())");
		System.out.println(result1);

		// null을 가진 객체를 뒤로 보낸다.
		List<Member> memberList = Arrays.asList(Member.of(10), Member.of(null), Member.of(5));
		List<Member> result2 = memberList.stream()
				.sorted(Comparator.comparing(Member::getAge, Comparator.nullsFirst(Comparator.reverseOrder())))
				.collect(toList());
		System.out.println("null을 가진 객체를 뒤로 보낸다. Comparator.nullsLast(Comparator.reverseOrder())");
		System.out.println(result2);
	}

	public static class Member {
		private Integer age;

		public Member(Integer age) {
			this.age = age;
		}

		public static Member of(Integer age) {
			return new Member(age);
		};

		public Integer getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Member{" +
				   "age=" + age +
				   '}';
		}
	}



}
