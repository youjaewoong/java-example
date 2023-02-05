package stream;

import static java.util.stream.Collectors.*;

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

/**
 * grouping method
 */
public class StreamEx02 {

	public static void main(String[] args) {
		List<BlogPost> posts = DataGenerator.getBlogPosts();

		System.out.println("타입별 그룹");
		Map<BlogPostType, List<BlogPost>> postsPerType1 = posts.stream()
				.collect(groupingBy(BlogPost::getType));
		System.out.println(postsPerType1);
		System.out.println();

		System.out.println("타입과 저자 기준으로 그룹을 묶는다.");
		Map<Tuple, List<BlogPost>> postsPerType2 = posts.stream()
				.collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
		System.out.println(postsPerType2);
		System.out.println();

		System.out.println("Collectors.toSet() 로 타입의 중복을 없애고 그룹을 묶는다.");
		Map<BlogPostType, Set<BlogPost>> postsPerType3 = posts.stream()
				.collect(groupingBy(BlogPost::getType, Collectors.toSet()));
		System.out.println(postsPerType3);
		System.out.println();

		System.out.println("averagingInt() 로 그룹화 된 결과에서 평균값을 얻는다.");
		Map<BlogPostType, Double> averageLikesPerType = posts.stream()
				.collect(groupingBy(BlogPost::getType,
						Collectors.averagingInt(BlogPost::getLikes)));
		System.out.println(averageLikesPerType);
		System.out.println();

		System.out.println("summingInt() 로 그룹화 된 결과에서 합계 얻기.");
		Map<BlogPostType, Integer> likesPerType = posts.stream()
				.collect(groupingBy(BlogPost::getType,
						Collectors.summingInt(BlogPost::getLikes)));
		System.out.println(likesPerType);
		System.out.println();

		System.out.println("그룹화 된 결과에서 최대 또는 최소값 얻기");
		Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
				.collect(groupingBy(BlogPost::getType,
						maxBy(Comparator.comparingInt(BlogPost::getLikes))));
		System.out.println(maxLikesPerPostType);
		System.out.println();

		System.out.println("그룹화 된 결과 속성에 대한 요약 가져오기");
		Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
				.collect(groupingBy(BlogPost::getType,summarizingInt(BlogPost::getLikes)));
		System.out.println(likeStatisticsPerType);
		System.out.println();

		System.out.println("반환 맵 유형 수정");
		EnumMap<BlogPostType, List<BlogPost>> postPerTypeEnumMap = posts.stream()
				.collect(groupingBy(BlogPost::getType,
						() -> new EnumMap<>(BlogPostType.class), Collectors.toList()));
		System.out.println(postPerTypeEnumMap);
		System.out.println();

		System.out.println("Collector 별 동시 그룹화");
		ConcurrentMap<BlogPostType, List<BlogPost>> postPerTypeConcurrentMap = posts.parallelStream()
				.collect(groupingByConcurrent(BlogPost::getType));
		System.out.println(postPerTypeConcurrentMap);
	}

	public static class Tuple {
		BlogPostType type;
		String author;

		public Tuple(BlogPostType type, String author) {
			this.type = type;
			this.author = author;
		}
	}

	public static class DataGenerator {
		public static List<BlogPost> getBlogPosts() {
			List<BlogPost> posts = new ArrayList<BlogPost>();
			posts.add(new BlogPost("홍길동 외전1", "홍길동1", BlogPostType.NEWS, 1));
			posts.add(new BlogPost("유관순 외전2", "유관순2", BlogPostType.NEWS, 2));
			posts.add(new BlogPost("정약용 외전3", "정약용3", BlogPostType.NEWS, 3));

			posts.add(new BlogPost("홍길동 외전1", "홍길동1", BlogPostType.GUIDE, 1));
			posts.add(new BlogPost("유관순 외전2", "유관순2", BlogPostType.GUIDE, 2));
			posts.add(new BlogPost("정약용 외전3", "정약용3", BlogPostType.GUIDE, 3));

			return posts;
		}

		;
	}

	public static class BlogPost {
		String title;
		String author;
		BlogPostType type;
		int likes;

		public BlogPost(String title, String author, BlogPostType type, int likes) {
			this.title = title;
			this.author = author;
			this.type = type;
			this.likes = likes;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public BlogPostType getType() {
			return type;
		}

		public void setType(BlogPostType type) {
			this.type = type;
		}

		public int getLikes() {
			return likes;
		}

		public void setLikes(int likes) {
			this.likes = likes;
		}

		@Override
		public String toString() {
			return "BlogPost{" +
				   "title='" + title + '\'' +
				   ", author='" + author + '\'' +
				   ", type=" + type +
				   ", likes=" + likes +
				   '}';
		}
	}

	public enum BlogPostType {
		NEWS, REVIEW, GUIDE
	}

}

