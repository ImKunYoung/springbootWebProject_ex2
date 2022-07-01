package com.example.ex2.repository;


import com.example.ex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoryRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() { System.out.println(memoRepository.getClass().getName()); }
    /* 등록 작업 테스트 */
    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });
    }
    /* 조회 작업 테스트 1 */
    @Test
    public void testSelect() { // 데이터베이스 먼저 이용
        // 데이터베이스에 존재하는 mno
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("========================================");

        // result가 존재하면 print memo
        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }
    /* 조회 작업 테스트 2 */
    @Transactional
    @Test
    public void testSelect2() { // 데이터베이스 필요한 순간
        // 데이터베이스에 존재하는 mno
        Long mno = 100L;

        Memo memo = memoRepository.getReferenceById(mno);

        System.out.println("========================================");

        System.out.println(memo);
    }
    /* 수정 작업 테스트 */
    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(memoRepository.save(memo));
    }
    /* 삭제 작업 테스트 */
    @Test
    public void testDelete() {
        Long mno = 100L;
        memoRepository.deleteById(mno);
    }



}
