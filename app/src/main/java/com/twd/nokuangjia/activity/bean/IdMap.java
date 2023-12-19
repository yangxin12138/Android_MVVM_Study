package com.twd.nokuangjia.activity.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Yangxin
 * @Description:
 * @time: Create in 14:14 2023/12/19
 */
public class IdMap {
    Map<String,String> idMap = new HashMap<>();

    public IdMap() {
        idMap.put("yangxin","520181199811123319");
        idMap.put("lisi","522525199708094526");
    }

    public Map<String, String> getIdMap() {
        return idMap;
    }
}
