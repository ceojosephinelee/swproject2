package swproject2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookSearchBSTest {

    private Book[] books;
    private BookSearchBS bookSearch;

    // 각 테스트 전에 Book 배열과 BookSearch 인스턴스를 초기화
    @BeforeEach
    public void setUp() {
        books = new Book[]{
            new Book(1, "Title1", "Author1", 2001),
            new Book(2, "Title2", "Author2", 2002),
            new Book(3, "Title3", "Author3", 2003),
            new Book(4, "Title4", "Author4", 2004),
            new Book(5, "Title5", "Author5", 2005)
        };
        bookSearch = new BookSearchBS(books);
    }

    // 존재하는 책을 검색하는 테스트
    @Test
    public void testSearchBookFound() {
        Book book = bookSearch.search_bs(3);
        System.out.println("이진 탐색: 책을 찾았습니다. ID: 3");
        assertEquals(3, book.getId());
        assertEquals("Title3", book.getTitle());
        assertEquals("Author3", book.getAuthor());
        assertEquals(2003, book.getYear());
    }

    // 존재하지 않는 책을 검색하는 테스트
    @Test
    public void testSearchBookNotFound() {
        Book book = bookSearch.search_bs(6);
        System.out.println("이진 탐색: 책을 찾지 못했습니다. ID: 6");
        assertNull(book);
    }

    // 첫 번째 책을 검색하는 테스트
    @Test
    public void testSearchBookFirstElement() {
        Book book = bookSearch.search_bs(1);
        System.out.println("이진 탐색: 첫 번째 책을 찾았습니다. ID: 1");
        assertEquals(1, book.getId());
        assertEquals("Title1", book.getTitle());
        assertEquals("Author1", book.getAuthor());
        assertEquals(2001, book.getYear());
    }

    // 마지막 책을 검색하는 테스트
    @Test
    public void testSearchBookLastElement() {
        Book book = bookSearch.search_bs(5);
        System.out.println("이진 탐색: 마지막 책을 찾았습니다. ID: 5");
        assertEquals(5, book.getId());
        assertEquals("Title5", book.getTitle());
        assertEquals("Author5", book.getAuthor());
        assertEquals(2005, book.getYear());
    }

    // 중간에 위치한 책을 검색하는 테스트
    @Test
    public void testSearchBookMiddleElement() {
        Book book = bookSearch.search_bs(3);
        System.out.println("이진 탐색: 중간에 위치한 책을 찾았습니다. ID: 3");
        assertEquals(3, book.getId());
        assertEquals("Title3", book.getTitle());
        assertEquals("Author3", book.getAuthor());
        assertEquals(2003, book.getYear());
    }
}

