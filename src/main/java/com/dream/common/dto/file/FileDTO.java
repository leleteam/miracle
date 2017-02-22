package com.dream.common.dto.file;

import com.dream.common.dto.enums.EnumCommonString;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "文件对象")
@Data
@NoArgsConstructor
public class FileDTO implements Serializable {
    private String id;
    @Size(min = 1, max = 100, message = "文件名称应在1-100个字符之间")
    @NotBlank(message = "文件名称不能为空")
    private String name;
    private String type;
    @Size(min = 1, max = 500, message = "文件路径应在1-500个字符之间")
    @NotBlank(message = "文件路径不能为空")
    private String url;
    private String description;
    private String taskId;
    private String processInstanceId;
    private String userId;
    @JsonFormat(pattern = EnumCommonString.LocalDateTime_Pattern, timezone = EnumCommonString.GMT_8)
    private Date time;

    public FileDTO(String name, String type, String url) {
        this.name = name;
        this.url = url;
        this.type = type;
    }
}
