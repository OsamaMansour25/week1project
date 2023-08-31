package dat3.car.car.api;

import dat3.car.car.dto.MemberRequest;
import dat3.car.car.dto.MemberResponse;
import dat3.car.car.entity.Member;
import dat3.car.car.repository.MemberRepository;
import dat3.car.car.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/members")
class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //Security Admin only
    @GetMapping
    List<MemberResponse> getMembers(){
        return memberService.getMembers(false);
    }

    //Security admin
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {
        return memberService.findById(username);
    }

    //Security > Anonymous/ALL can access
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }

    //Security > User
    @PutMapping("/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        return memberService.editMember(body, username);
    }
    //Security ADMIN
    @PatchMapping("/ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value) {
        memberService.setRankingForUser(username,value);
    }

    // Security ADMIN
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {
        memberService.deleteMemberByUsername(username);
    }
}

