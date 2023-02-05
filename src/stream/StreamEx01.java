package stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream
 */
public class StreamEx01 {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api developement", false));

		List<OnlineClass> javaClasses = new ArrayList<>();
		javaClasses.add(new OnlineClass(6, "The Java , Test", true));
		javaClasses.add(new OnlineClass(7, "The Java , Code manipulation", true));
		javaClasses.add(new OnlineClass(8, "The Java , 8 to 11", true));

		List<List<OnlineClass>> jinSeokEvents = new ArrayList<>();
		jinSeokEvents.add(springClasses);
		jinSeokEvents.add(javaClasses);

		System.out.println("spring 으로 시작하는 수업");
		springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("spring"))
				.forEach(oc -> System.out.println(oc.getTitle()));

		System.out.println("====================================");

		System.out.println("filter 속성으로 close 되지 않은 수업 확인");
		springClasses.stream()
				.filter(oc -> !oc.isClosed())
				//			.filter(OnlineClass::isClosed) // 메소드 래퍼런스 이용
				//			.filter(Predicate.not(OnlineClass::isClosed))
				.forEach(oc -> System.out.println(oc.getTitle()));

		System.out.println("====================================");
		System.out.println("수업 이름만 모아서 스트림 만들기");
		springClasses.stream()
				//			.map(oc -> oc.getTitle())
				.map(OnlineClass::getTitle) // 메소드 래퍼런스 이용
				.forEach(oc -> System.out.println(oc));

		System.out.println("====================================");
		System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
		jinSeokEvents.stream()
				//			.flatMap(list -> list.stream())
				.flatMap(Collection::stream)
				.forEach(oc -> System.out.println(oc.getId()));

		System.out.println("====================================");
		System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
		Stream.iterate(10, i -> i + 1)
				.skip(10)
				.limit(10)
				//			.forEach(i -> System.out.println(i));
				.forEach(System.out::println);

		System.out.println("========= anyMatch 를 사용하면 하나라도 통과하면 true =========");
		System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
		boolean test = javaClasses.stream()
				.anyMatch(oc -> oc.getTitle().contains("Test"));
		System.out.println(test);

		System.out.println("====================================");
		System.out.println("스프링 수업 중에 제목이 spring이 들어간 제목을 모아서 List만들기");
		List<String> spring = springClasses.stream()
				.filter(oc -> oc.getTitle().contains("spring"))
				.map(oc -> oc.getTitle())
				.collect(Collectors.toList());
		spring.forEach(System.out::println);

	}

	public static class OnlineClass {
		private Integer id;
		private String title;
		private boolean closed;

		public OnlineClass(Integer id, String title, boolean closed) {
			this.id = id;
			this.title = title;
			this.closed = closed;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isClosed() {
			return closed;
		}

		public void setClosed(boolean closed) {
			this.closed = closed;
		}
	}

}

