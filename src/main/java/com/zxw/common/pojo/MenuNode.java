package com.zxw.common.pojo;

import com.zxw.jwxt.domain.AuthFunction;
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

    private AuthFunction authFunction;
    private List<MenuNode> list = new ArrayList<>();

}
