package com.zxw.jwxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zxw
 * @date 2019/11/6 20:23
 */
@RequestMapping("/")
@Controller
public class IndexController extends BaseController {

    @GetMapping("/")
    public String index() {
        return "web/login";
    }

    @GetMapping("/main")
    public String main(Model model) {
        return "/web/index0";
    }

    @GetMapping("/main/data")
    @ResponseBody
    public Map<String, Object> mainData() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage nonHeapMemoryUsage = mem.getNonHeapMemoryUsage();
        MemoryUsage heapMemoryUsage = mem.getHeapMemoryUsage();
        //初始的总内存
        long init = heapMemoryUsage.getInit();
        //最大可用内存
        long max = heapMemoryUsage.getMax();
        //已使用的内存
        long used = heapMemoryUsage.getUsed();
        long total = heapMemoryUsage.getCommitted();
        long max1 = nonHeapMemoryUsage.getMax() / 1024 / 1024;
        long free = (nonHeapMemoryUsage.getCommitted() - nonHeapMemoryUsage.getUsed()) / 1024 / 1024;
        long used1 = nonHeapMemoryUsage.getUsed() / 1024 / 1024;
        long total1 = nonHeapMemoryUsage.getCommitted() / 1024 / 1024;
        long totalMemory = total / 1024 / 1024;
        long freeMemory = (total - used) / 1024 / 1024;
        long maxMemory = max / 1024 / 1024;
        long UsedMemory = used / 1024 / 1024;
        map.put("totalMemory", totalMemory);
        map.put("freeMemory", freeMemory);
        map.put("maxMemory", maxMemory);
        map.put("UsedMemory", UsedMemory);
        map.put("nontotalMemory", total1);
        map.put("nonfreeMemory", free);
        map.put("nonmaxMemory", max1);
        map.put("nonUsedMemory", used1);
        return map;
    }

    @GetMapping("/page/{page}")
    public String page(@PathVariable("page") String page) {
        return "/web/" + page;
    }

    @GetMapping("/page/{category}/{page}")
    public String page(@PathVariable("category") String category, @PathVariable("page") String page) {
        return "/web/" + category + "/" + page;
    }
}
