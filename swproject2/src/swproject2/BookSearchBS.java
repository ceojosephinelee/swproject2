package swproject2;


import java.util.Arrays;

public class BookSearchBS {

    private Book[] books; // 책 객체 배열

    // BookSearchBS 생성자: 주어진 책 배열을 초기화하고 ID 순서로 정렬
    public BookSearchBS(Book[] books) {
        this.books = books;
        Arrays.sort(this.books, (b1, b2) -> Integer.compare(b1.getId(), b2.getId()));
    }

    // 책의 고유 아이디를 사용하여 이진 탐색을 통해 책을 찾는 메서드
    public Book search_bs(int targetId) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (books[mid].getId() == targetId) {
                return books[mid];
            } else if (books[mid].getId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // 책을 찾지 못한 경우
    }

    // 메인 메서드: BookSearchBS를 테스트
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Title1", "Author1", 2001),
            new Book(2, "Title2", "Author2", 2002),
            new Book(3, "Title3", "Author3", 2003),
            new Book(4, "Title4", "Author4", 2004),
            new Book(5, "Title5", "Author5", 2005)
        };

        BookSearchBS bookSearch = new BookSearchBS(books);

        int targetId = 3;
        Book result = bookSearch.search_bs(targetId);

        if (result != null) {
            System.out.println("책을 찾았습니다: " + result);
        } else {
            System.out.println("책을 찾지 못했습니다.");
        }
    }
}
