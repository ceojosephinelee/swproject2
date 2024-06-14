package swproject2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookSearchBSTest {

    private Book[] books;
    private BookSearchBS bookSearch;

    // 각 테스트 전에 Book 배열과 BookSearchBS 인스턴스를 초기화
    @BeforeEach
    public void setUp() {
        books = new Book[10000];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(i + 1, "Title" + (i + 1), "Author" + (i + 1), 2000 + (i % 20));
        }
        bookSearch = new BookSearchBS(books);
    }

    // 존재하는 책을 검색하는 테스트 (일반 탐색)
    @Test
    public void testSearchFound() {
        Book book = bookSearch.search(5000);
        assertNotNull(book);
        assertEquals(5000, book.getId());
    }

    // 존재하지 않는 책을 검색하는 테스트 (일반 탐색)
    @Test
    public void testSearchNotFound() {
        Book book = bookSearch.search(10001);
        assertNull(book);
    }

    // 존재하는 책을 검색하는 테스트 (이진 탐색)
    @Test
    public void testSearchBsFound() {
        Book book = bookSearch.search_bs(5000);
        assertNotNull(book);
        assertEquals(5000, book.getId());
    }

    // 존재하지 않는 책을 검색하는 테스트 (이진 탐색)
    @Test
    public void testSearchBsNotFound() {
        Book book = bookSearch.search_bs(10001);
        assertNull(book);
    }

    // 일반 탐색과 이진 탐색의 성능을 비교하는 테스트
    @Test
    public void testComparePerformance() {
        int targetId = 5000;
        System.out.println("=== 성능 비교 시작 ===");
        bookSearch.comparePerformance(targetId);
        System.out.println("=== 성능 비교 종료 ===");
    }
}
