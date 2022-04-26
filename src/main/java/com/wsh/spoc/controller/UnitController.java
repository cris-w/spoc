package com.wsh.spoc.controller;

import com.wsh.spoc.entity.Unit;
import com.wsh.spoc.entity.Vo.UnitVo;
import com.wsh.spoc.service.UnitService;
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
 * @date 2022/4/23 01:05
 */
@Api(tags = "单元管理")
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Resource
    private UnitService unitService;

    /**
     * 获取单元列表
     *
     * @return list
     */
    @GetMapping("/list/{classroomId}")
    public R<List<UnitVo>> list(@PathVariable Integer classroomId) {
        List<UnitVo> list = unitService.listUnitAndVideo(classroomId);
        return R.success(list);
    }

    /**
     * 创建单元
     *
     * @param unit unit
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody Unit unit) {
        unitService.save(unit);
        return R.success("创建成功");
    }

    /**
     * 删除单元
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/removeById/{id}")
    public R<Void> removeById(@PathVariable Integer id) {
        unitService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 通过id获取单元信息
     *
     * @param id id
     * @return c
     */
    @GetMapping("/getById/{id}")
    public R<Unit> getById(@PathVariable Integer id) {
        Unit unit = unitService.getById(id);
        return R.success(unit);
    }

    /**
     * 修改单元信息
     *
     * @param unit unit
     * @return ok
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Unit unit) {
        unitService.updateById(unit);
        return R.success("修改成功");
    }
}
