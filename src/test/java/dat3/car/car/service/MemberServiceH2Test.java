package dat3.car.car.service;

import static org.junit.jupiter.api.Assertions.*;

import dat3.car.car.dto.MemberResponse;
import org.junit.jupiter.api.BeforeEach;
import dat3.car.car.dto.MemberRequest;
import dat3.car.car.entity.Member;
import dat3.car.car.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberServiceH2Test {

    @Autowired
    MemberRepository memberRepository;
    MemberService memberService;

    Member m1, m2;  //Talk about references in Java for why we don't add the "isInitialize flag"

    @BeforeEach
    void setUp() {
        m1 = memberRepository.save(new Member("user1", "pw1", "email1", "fn1", "ln1",  "street1", "city1", "zip1"));
        m2 = memberRepository.save(new Member("user2", "pw2", "email1", "fn2", "ln2", "street2", "city2", "zip2"));
        memberService = new MemberService(memberRepository); //Set up memberService with the mock (H2) database
    }

    @Test
    void testGetMembersAllDetails() {
        //Todo
    }

    @Test
    void testGetMembersNoDetails() {
        //Todo
    }
   // fra
    @Test
    void testFindByIdFound() {
        MemberResponse m1 = memberService.findById("user2");
        assertEquals(m1.getUsername(), "user2");
    }
    @Test
    void testFindByIdNotFound() {
            // Ensure that the repository does not contain the member with username "user3"
            ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> memberService.findById("user3"));
            // Check that the exception has the correct status code (HTTP 400)
            assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
        /* Remember MemberRequest comes from the API layer, and MemberResponse is returned to the API layer
         * Internally addMember savex a Member entity to the database*/
    void testAddMember_UserDoesNotExist() {
        MemberRequest request = new MemberRequest("new user", "newuser@example.com", "password", "name", "lastName", "street", "City", "123");

        memberService.addMember(request);
        MemberResponse response = memberService.findById("new user");
        assertEquals(response.getUsername(), request.getUsername());

    }

    @Test
    void testAddMember_UserDoesExistThrows() {
        MemberRequest request = new MemberRequest("new user", "newuser@example.com", "password", "name", "lastName", "street", "City", "123");

        memberService.addMember(request);
        MemberRequest request2 = new MemberRequest("new user", "newuser@example.com", "password", "name", "lastName", "street", "City", "123");


        // Ensure that the repository does not contain the member with username "user3"
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> memberService.addMember(request2));
        // Check that the exception has the correct status code (HTTP 400)
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
 // til her
    @Test
    void testEditMemberWithExistingUsername() {
        //TODO
    }

    @Test
    void testEditMemberNON_ExistingUsernameThrows() {
        //This should test that a ResponseStatus exception is thrown with status= 404 (NOT_FOUND)
        //TODO
    }

    @Test
    void testEditMemberChangePrimaryKeyThrows() {
        //Create a MemberRequest from an existing member we can edit
        MemberRequest request = new MemberRequest(m1);
        //TODO
    }

    @Test
    void testSetRankingForUser() {
        //TODO
    }

    @Test
    void testSetRankingForNoExistingUser() {
        //TODO
    }
    @Test
    void testDeleteMemberByUsername() {
        //TODO
    }

    @Test
    void testDeleteMember_ThatDontExist() {
        //TODO
    }
}

