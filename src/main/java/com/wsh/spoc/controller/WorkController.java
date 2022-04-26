package com.wsh.spoc.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wsh.spoc.entity.Twork;
import com.wsh.spoc.exception.MyException;
import com.wsh.spoc.service.OosService;
import com.wsh.spoc.service.TworkService;
import com.wsh.spoc.utils.R;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/4/24 18:40
 */
@Api(tags = "作业管理")
@RestController
@RequestMapping("/work")
public class WorkController {

    @Resource
    private TworkService tworkService;
    @Resource
    private OosService oosService;

    /**
     * 获取作业列表
     *
     * @return list
     */
    @GetMapping("/list/{userId}")
    public R<List<Twork>> list(@PathVariable Integer userId) {
        List<Twork> list = tworkService.list(
                new LambdaQueryWrapper<Twork>().eq(Twork::getUserId, userId));
        return R.success(list);
    }

    /**
     * 创建作业
     *
     * @param twork twork
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody Twork twork) {
        tworkService.save(twork);
        return R.success("创建成功");
    }

    /**
     * 删除作业
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/removeById/{id}")
    public R<Void> removeById(@PathVariable Integer id) {
        Twork work = tworkService.getById(id);
        if(StrUtil.isNotBlank(work.getOriginalName())) {
           if (!oosService.deleteFile(work.getOriginalName())) {
               throw new MyException(400, "文件删除失败");
           }
        }
        tworkService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 通过id获取作业信息
     *
     * @param id id
     * @return c
     */
    @GetMapping("/getById/{id}")
    public R<Twork> getById(@PathVariable Integer id) {
        Twork twork = tworkService.getById(id);
        return R.success(twork);
    }

    /**
     * 修改作业信息
     *
     * @param twork twork
     * @return ok
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Twork twork) {
        tworkService.updateById(twork);
        return R.success("修改成功");
    }


}
