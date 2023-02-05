package optional;

import static java.util.stream.Collectors.*;
import static optional.OptionalEx01.OptionalMain.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import stream.StreamEx01;

/**
 * grouping method
 */
public class OptionalEx01 {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = DataGenerator.getOnlineClass();
		// of null이 아닌 객체를 담고 있는 Optional 객체를 생성합니다.
		Optional<List<OnlineClass>> of = Optional.of(springClasses);
		// null을 담고 있는, 한 마디로 비어있는 Optional 객체를 얻어옵니다.
		// 이 비어있는 객체는 Optional 내부적으로 미리 생성해놓은 싱글턴 인스턴스입니다.
		Optional<List<OnlineClass>> empty = Optional.empty();
		// 해당 객체가 null인지 아닌지 자신이 없는 상황에서는 이 메소드를 사용하셔야 합니다.
		Optional<List<OnlineClass>> ofNullable = Optional.ofNullable(springClasses);

		Optional<OnlineClass> optional = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("spring"))
				.findFirst();

		Optional<OnlineClass> optional2 = springClasses.stream()
				.filter(oc -> oc.getTitle().startsWith("jpa"))
				.findFirst();

		// ifPresent() 값이 있으면 처리
		// Consumer람다식을 쓸 수 있으며 if문을 쓰지 않고 간편하게 처리 할 수 있다.
		optional.ifPresent(oc -> {
		    System.out.println(oc.getTitle());
		});

		// orElse()
		// 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라.
		OnlineClass onlineClass1 = optional.orElse(createNewClass());
		System.out.println(onlineClass1.getTitle());

		OnlineClass onlineClass2 = optional2.orElse(createNewClass());
		System.out.println(onlineClass2.getTitle());

		// orElseGet()
		// 함수형 인터페이스로 supplier를 사용한다. supplier는 lazy evaluation이 필요할 때 주로 이용되는데 이는 다음 포스팅을 참고하자.
		OnlineClass onlineClass3 = optional.orElseGet(OptionalMain::createNewClass);
		System.out.println(onlineClass3.getTitle());

		// orElseThrow()
		// Optional에 값이 있으면 가져오고 없으면 에러를 발생시킨다.
		//OnlineClass onlineClass4 = optional2.orElseThrow(IllegalArgumentException::new);

		// Optional에 값이 있는지 없는지 확인하기
		Optional<OnlineClass> onlineClass =
				optional.filter(OnlineClass::isClosed);
		System.out.println(onlineClass.isPresent());
		System.out.println(onlineClass.isPresent());

		// get()
		// get()은 현재 Optional안에 객체가 있으면 리턴하고, 없으면 RuntimeException을 발생시킨다. get()의 경우 다른 api로 커버할 수 있으므로 사용을 최대한 자제해야 한다.
		OnlineClass oc = optional.get();
		System.out.println(oc.getId() + " " + oc.getTitle());
		//OnlineClass oc2 = optional2.get(); // 비어있기 때문에 RuntimeException 발생

		// map(Function)
		Optional<String> title = optional.map(OnlineClass::getTitle);
		System.out.println(title.get());

		// flatMap
		// map의 리턴 값으로 Optional<>이 리턴 된다면 다음과 같이 두 번 Optional을 벗겨내는 일을 해야 한다.
		Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
		Optional<Progress> progress1 = progress.orElseThrow();
		Progress progress2 = progress1.orElseThrow();
		System.out.println(progress2);

		// flatMap은 이런 과정을 줄여준다.
		// Optional flatMap(Function): Optional 안에 들어있는 인스턴스가 Optional인 경우에
		// 사용하면 편리하다.
		Optional<Progress> progress3 = optional.flatMap(OnlineClass::getProgress);
		System.out.println(progress3);

	}

	public static class OptionalMain {
		static OnlineClass createNewClass() {
			return new OnlineClass(10, "new class", false);
		};
	}

	public static class DataGenerator {
		public static List<OnlineClass> getOnlineClass() {
			List<OnlineClass> springClasses = new ArrayList<>();
			springClasses.add(new OnlineClass(1, "spring boot", true));
			springClasses.add(new OnlineClass(2, "spring data jpa", true));
			springClasses.add(new OnlineClass(3, "spring mvc", false));
			springClasses.add(new OnlineClass(4, "spring core", false));
			springClasses.add(new OnlineClass(5, "rest api developement", false));
			return springClasses;
		}
	}

	public static class OnlineClass {
		private Integer id;
		private String title;
		private boolean closed;
		public Progress progress;

		public OnlineClass() {
		}

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

		public Optional<Progress> getProgress() {
			return Optional.ofNullable(progress);
		}

		public void setProgress(Progress progress) {
			this.progress = progress;
		}
	}
	public static class Progress {

		private Duration studyDuration;

		private boolean finished;

		public Duration getStudyDuration() {
			return studyDuration;
		}

		public void setStudyDuration(Duration studyDuration) {
			this.studyDuration = studyDuration;
		}
	}

}

