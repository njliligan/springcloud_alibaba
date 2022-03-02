package com.njganlili.commonservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.Assert;
import net.sf.oval.constraint.NotBlank;


/**
 * <p>
 * 
 * </p>
 *
 * @author miky
 * @since 2022-02-27
 */
@Getter
@Setter
@TableName("users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    @TableField("user_name")
    @Assert(expr = "_value != '1' ",lang = "javascript", message = "很抱歉，暂时只支持线下打款方式")
    private String userName;

    @TableField("user_age")
    private Integer userAge;

    @TableField("user_sex")
    private String userSex;

    @TableField("user_id_card")
    @NotBlank(message = "idcard 不能为空",when = "javascript:_this.userName == '1'")
    private String userIdCard;

    @TableField("revision")
    private String revision;

    @TableField("created_by")
    private String createdBy;

    @TableField("created_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdTime;

    @TableField("updated_by")
    private String updatedBy;

    @TableField("updated_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedTime;


}
