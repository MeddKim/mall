package com.mall.core.domain.utils;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageInfo {

    private int totalCount; //总记录数目
    private int totalPages; //
    private int page;   //页数
    private int limit;  //分页大小
    private List items;

    private int startRow;
    private int endRow;
    private int offset;
    private Integer[] slider;
    private int prePage;
    private int nextPage;
    private boolean firstPage;
    private boolean hasNextPage;
    private boolean hasPrePage;
    private boolean lastPage;


    public PageInfo(List list){
        int currentPageNum;
        int declarePageSize;
        int totalItem;
        if (list instanceof Page) {
            final Page page = (Page) list;
            currentPageNum = page.getPageNum();
            declarePageSize = page.getPageSize();
            totalItem = (int) page.getTotal();
        } else {
            currentPageNum = 1;
            declarePageSize = list.size();
            totalItem = list.size();
        }


        Paginator pageInfoUtils = new Paginator(currentPageNum, declarePageSize, totalItem);
        this.items = new ArrayList();
        this.initPageInfo(pageInfoUtils);
    }

    private void initPageInfo(Paginator pageInfoUtils){
        this.totalCount = pageInfoUtils.getTotalCount();
        this.totalPages = pageInfoUtils.getTotalPages();
        this.page = pageInfoUtils.getPage();
        this.limit = pageInfoUtils.getLimit();
        this.startRow = pageInfoUtils.getStartRow();
        this.endRow = pageInfoUtils.getEndRow();
        this.offset = pageInfoUtils.getOffset();
        this.slider = pageInfoUtils.getSlider();
        this.prePage = pageInfoUtils.getPrePage();
        this.nextPage = pageInfoUtils.getNextPage();
        this.firstPage = pageInfoUtils.isFirstPage();
        this.hasNextPage = pageInfoUtils.isHasNextPage();
        this.hasPrePage = pageInfoUtils.isHasPrePage();
        this.lastPage = pageInfoUtils.isLastPage();
    }

    public void add(Object object){
        this.items.add(object);
    }
}