package com.wsh.spoc.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wsh.spoc.entity.Score;
import com.wsh.spoc.exception.MyException;
import com.wsh.spoc.service.ScoreService;
import com.wsh.spoc.utils.OosUtil;
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
 * @date 2022/4/26 18:17
 */
@Api(tags = "成绩管理")
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;
    @Resource
    private OosUtil oosUtil;

    /**
     * 获取作业列表
     *
     * @return list
     */
    @GetMapping("/list/{tworkId}")
    public R<List<Score>> list(@PathVariable Integer tworkId) {
        List<Score> list = scoreService.list(
                new LambdaQueryWrapper<Score>().eq(Score::getTworkId, tworkId));
        return R.success(list);
    }

    /**
     * 打回作业
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/removeById/{id}")
    public R<Void> removeById(@PathVariable Integer id) {
        Score score = scoreService.getById(id);
        if(StrUtil.isNotEmpty(score.getOriginalName())) {
            boolean flag = oosUtil.delete(score.getOriginalName());
            if(!flag) {
                throw new MyException(400, "删除文件错误");
            }
        }
        scoreService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 通过id获取作业信息
     *
     * @param id id
     * @return c
     */
    @GetMapping("/getById/{id}")
    public R<Score> getById(@PathVariable Integer id) {
        Score score = scoreService.getById(id);
        return R.success(score);
    }

    /**
     * 批阅作业
     *
     * @param score score
     * @return ok
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Score score) {
        scoreService.updateById(score);
        return R.success("修改成功");
    }
}
