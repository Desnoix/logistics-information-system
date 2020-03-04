package com.yjq.common.Controller;

import com.github.pagehelper.PageHelper;
import com.yjq.common.ResultVO;
import com.yjq.common.utils.SqlUtil;
import com.yjq.common.utils.StringUtils;
import com.yjq.common.utils.page.PageDomain;
import com.yjq.common.utils.page.TableSupport;

import java.util.Map;

/**
 * @ClassName BaseController
 * @Author GDMZ_jqyang@outlook.com
 * @Description web层通用数据处理
 * @Date 2020/2/26 21:56
 * @Version 1.0
 */
public class BaseController {
    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected Map<String, Object> toResult(int rows)
    {
        return rows > 0 ? ResultVO.success() : ResultVO.failure();
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }


}
