package com.kodstar.issuetracker.repo;

import com.kodstar.issuetracker.entity.Issue;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {
    List<Issue> findAll();

    @Query(value="select * from t_issue i where i.issue_title like %:keyword% or i.issue_description like %:keyword%", nativeQuery=true)
    List<Issue> findALlByTitleKeyword(@Param("keyword") String keyword);

    @Query(value="select * from t_issue i where  i.issue_description like %:keyword%", nativeQuery=true)
    List<Issue> findALlByDescKeyword(@Param("keyword") String keyword);

    List<Issue> findAllByOrderByCreateTime();

    List<Issue> findAllByOrderByCreateTimeDesc();
}
