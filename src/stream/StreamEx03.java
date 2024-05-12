package stream;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * grouping method
 */
public class StreamEx03 {

	public static void main(String[] args) {
		List<User> users = Arrays.asList(
				new User(1, "a", "a@naver.com"),
				new User(2, "a", "b@naver.com"),
				new User(3, "b", "b@naver.com"),
				new User(4, "a", "a@naver.com"),
				new User(5, "a", "a@naver.com")
		);

		// 타입별 그룹
		Map<String, List<User>> groupedByType = users.stream()
				.collect(Collectors.groupingBy(User::getType));
		// 타입 수
		System.out.println("Type: " + groupedByType.size());

		// 타입별 그룹화 데이터 출력
		for (Map.Entry<String, List<User>> entry : groupedByType.entrySet()) {
			System.out.println("Type: " + entry.getKey());
			entry.getValue().forEach(System.out::println);
		}
		// 타입별 개수
		Map<String, Long> countByType = users.stream()
				.collect(Collectors.groupingBy(User::getType, Collectors.counting()));
		// 타이별 개수 데이터 출력
		for (Map.Entry<String, Long> entry : countByType.entrySet()) {
			System.out.println("Type: " + entry.getKey() + ", Count: " + entry.getValue());
		}

	}

	public static class User {
		private int id;
		private String type;
		private String email;

		public User(int id, String type, String email) {
			this.id = id;
			this.type = type;
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public String getType() {
			return type;
		}

		public String getEmail() {
			return email;
		}

		@Override
		public String toString() {
			return "User{" +
					"id=" + id +
					", type='" + type + '\'' +
					", email='" + email + '\'' +
					'}';
		}
	}
}

