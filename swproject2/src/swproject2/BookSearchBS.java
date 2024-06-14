package swproject2;

import java.util.Arrays;

public class BookSearchBS {

    private Book[] books; // 책 객체 배열

    // BookSearchBS 생성자: 주어진 책 배열을 초기화하고 ID 순서로 정렬
    public BookSearchBS(Book[] books) {
        this.books = books;
        Arrays.sort(this.books, (b1, b2) -> Integer.compare(b1.getId(), b2.getId()));
    }

    // 책의 고유 아이디를 사용하여 일반 탐색(선형 탐색)을 통해 책을 찾는 메서드
    public Book search(int targetId) {
        for (Book book : books) {
            if (book.getId() == targetId) {
                return book;
            }
        }
        return null;
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

    // 일반 탐색과 이진 탐색의 성능을 비교하는 메서드
    public void comparePerformance(int targetId) {
        long startTime, endTime;

        // 일반 탐색 성능 측정
        startTime = System.nanoTime();
        search(targetId);
        endTime = System.nanoTime();
        System.out.println("일반 탐색 시간: " + (endTime - startTime) + " 나노초");

        // 이진 탐색 성능 측정
        startTime = System.nanoTime();
        search_bs(targetId);
        endTime = System.nanoTime();
        System.out.println("이진 탐색 시간: " + (endTime - startTime) + " 나노초");
    }

    // 메인 메서드: BookSearchBS를 테스트 및 성능 비교
    public static void main(String[] args) {
        Book[] books = new Book[10000];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(i + 1, "Title" + (i + 1), "Author" + (i + 1), 2000 + (i % 20));
        }

        BookSearchBS bookSearch = new BookSearchBS(books);

        int targetId = 5000;

        System.out.println("=== 성능 비교 시작 ===");
        bookSearch.comparePerformance(targetId);
        System.out.println("=== 성능 비교 종료 ===");

        Book result = bookSearch.search(targetId);

        if (result != null) {
            System.out.println("일반 탐색: 책을 찾았습니다: " + result);
        } else {
            System.out.println("일반 탐색: 책을 찾지 못했습니다.");
        }

        result = bookSearch.search_bs(targetId);

        if (result != null) {
            System.out.println("이진 탐색: 책을 찾았습니다: " + result);
        } else {
            System.out.println("이진 탐색: 책을 찾지 못했습니다.");
        }
    }
}

