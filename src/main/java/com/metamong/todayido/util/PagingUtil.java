package com.metamong.todayido.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
    private int maxNum;//전체 게시글 개수
    private int pageNum;//현재 페이지 번호
    private int listCnt;//한 페이지에서 보여질 게시글 개수
    private int pageCnt;//보여질 페이지 번호의 개수
    private String listName;//게시판이 여러 개일 경우 페이징을 처리할 게시판의 이름 및 검색에 따라 달라지는 url을 저장
    //페이징용 uri와 링크<a>로 구성된 html 태그 문장을 작성하는 메소드
    public String makePaging(){
        String page = null;//html 태그 문장을 저장하는 변수
        //StringBuffer : 문자열 가공에 유용한 도구 객체
        StringBuffer sb = new StringBuffer();
        //1. 전체 페이지 개수 구하기
        int totalPage = (maxNum % listCnt) > 0 ? (maxNum / listCnt) + 1 : maxNum / listCnt;
        if(totalPage == 0) totalPage = 1;//게시글에 0개 일때 페이지 번호가 나오지 않음
        //2. 현재 페이지가 속해 있는 페이지 번호 그룹 구하기
        int curGroup = (pageNum % pageCnt) > 0 ? (pageNum / pageCnt) + 1 : pageNum / pageCnt;
        //3. 현재 페이지 그룹의 시작 번호 구하기
        int start = (curGroup * pageCnt) - (pageCnt - 1);
        //4. 현재 보이는 번호 그룹의 마지막 번호 구하기
        int end = (curGroup * pageCnt) >= totalPage ? totalPage : curGroup * pageCnt;
        //이전 버튼 처리 start가 1인 경우는 불필요
        if(start != 1){
            sb.append("<a class='pno' href='/" + listName + "pageNum=" + (start - 1) + "'>◀</a>");
        }
        //중간 번호 버튼 현재 보이는 페이지에는 링크를 붙이지 않는다
        for(int i = start; i <= end; i++){
            if(i != pageNum){//현재 페이지가 아닌 번호
                sb.append("<a class='pno' href='/" + listName + "pageNum=" + i + "'>" + i + "</a>");
            } else {//현재 페이지 번호
                sb.append("<font class='pno'>" + i + "</font>");
            }
        }
        //다음 버튼 처리 end 값이 totalPage와 같으면 생성하지 않는다
        if(end != totalPage){
            sb.append("<a class='pno' href='/" + listName + "pageNum=" + (end + 1) + "'>▶</a>");
        }
        //StringBuffer -> String으로 변환
        page = sb.toString();
        return page;
    }
}
