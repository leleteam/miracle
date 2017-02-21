package com.dream.common.dto.result;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel(value="page", description="分页参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page implements Serializable {
    private int page = 1;
    private int pageSize = 20;
    //开始检索的地方
    private Long offset = 0L;
    private Long total = 0L;                 //总条数

    public int getPageSize() {
        if (pageSize == 0) return 10;
        return this.pageSize;
    }

    public int getPage() {
        //如果page 太大，超过了 maxPage(最大页数),
        //如果count > 10， 设置page 为最大页， 如果count <= 10, 设置page 为第一页
        if (total % getPageSize() == 0 && page > (total / getPageSize())) {
            this.page = (int) (total / getPageSize());
        } else if (page > (total / getPageSize() + 1)) {
            this.page = (int) (total / getPageSize() + 1);
        }
        if (page == 0) page = 1;
        return this.page;
    }

    public int getOffset() {
        return (getPage() - 1) * getPageSize();
    }

    public void setPage(int page) {
        this.page = page < 1 ? 1 : page;
    }

    public int toIndex = Math.toIntExact(getPage() * getPageSize() < getTotal() ? getPage() * getPageSize() : getTotal());

}
