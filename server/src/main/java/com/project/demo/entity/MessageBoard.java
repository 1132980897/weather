package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 留言板：(MessageBoard)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MessageBoard")
public class MessageBoard implements Serializable {

    // MessageBoard编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_board_id")
    private Integer message_board_id;

    // 标题
    @Basic
    private String title;
    // 用户编号
    @Basic
    private Integer user_no;
    // 姓名
    @Basic
    private String full_name;
    // 发布时间
    @Basic
    private Timestamp release_time;
    // 内容描述
    @Basic
    private String content_description;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
