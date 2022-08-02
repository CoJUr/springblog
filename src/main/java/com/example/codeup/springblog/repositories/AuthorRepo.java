//package com.example.codeup.springblog.repositories;
//
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface AuthorRepo extends JpaRepository<Author, Long> {

//                    --   JPQL  --
//
//    @Query("FROM Author WHERE firstName = ?1")
//    List<Author> findByFirstName(String firstName);
//
//    @Query("SELECT a FROM Author a WHERE a.firstname = ?1 AND a.lastname = ?2")
//    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
//
//
//
//
////    sorts and order bys    order by attribute of entity
//    @Query("FROM Author WHERE firstName = ?1 ORDER BY lastName ASC")
//    List<Author> FindByFirstNameOrderByLastName(String firstName);
//
////    adding sort perameter to definition of query.
//    @Query("FROM Author WHERE firstName = ?1")
//    List<Author> findByFirstName(String firstName, Sort sort);
//
//    @Query("FROM Author Where UPPER(firstName) LIKE CONCAT('%', UPPER(?1), '%')")
//    List<Author> findByFirstNameContainingIgnoreCase(String firstName);
//
//
//    @Query("SELECT * FROM author WHERE first_name = :firstName", nativeQuery = true)
//    List<Author> findAuthorsByFirstName(@Param("firstName") String firstName);
//
//
////    Pagination
//    @Query("FROM author WHERE firstName = ?1")
//    List<Author> findByFirstName(String firstName, Pageable pageable);  //needs to be an obj that implements Pageable
//
////    entity name of the domain type of the repository gets prepended to the query. Will use author in this case.
//    @Query("FROM #{#entityName} WHERE firstName = ?1")
//    List<Author> findByFirstName(String firstName);
//
////    prepends % to the beginning and end of the string.
//    @Query("FROM Author WHERE UPPER(firstName) LIKE %?#{[0].toUpperCase()}%")
//    List<Author> findByFirstNameContainingIgnoreCase(String firstName);
//
//
//}
