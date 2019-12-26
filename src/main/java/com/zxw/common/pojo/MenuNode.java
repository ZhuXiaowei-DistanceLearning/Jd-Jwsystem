package com.zxw.common.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zxw.jwxt.domain.AuthFunction;
import com.zxw.jwxt.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuNode implements Serializable {
    private Long id;

    private String name;

    private String path;

    private Boolean hidden;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String redirect;
    private String component;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Boolean alwaysShow;
    private MenuMeta meta;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuNode> children;

}
