package com.distancelearning.authuser.repositories;

import com.distancelearning.authuser.models.User;
import com.distancelearning.authuser.models.UserCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserCourseRepository extends JpaRepository<UserCourseModel, UUID> {

    boolean existsByUserAndCourseId(User User, UUID CourseId);

    @Query(value = "select * from tb_users_courses where user_user_id = :userId", nativeQuery = true)
    List<UserCourseModel> findAllUserCourseIntoUser(@Param("userId") UUID userId);
}
