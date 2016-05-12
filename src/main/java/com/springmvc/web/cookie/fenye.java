package com.springmvc.web.cookie;

import com.springmvc.web.forum.entity.biao;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanghaoshao on 16/2/28.
 */
public class fenye
{
    private final static int pagesize=5;
    private ModelMap modelMap;
    private int First;
    private int total;


    private int a=0;
    private int last=0;

    //能够搜索的分页
    private int startRow=0;

    public fenye(ModelMap modelMap,int Frist,int total){
        this.modelMap=modelMap;
        this.First=Frist;
        this.total=total;
    }

    public ModelMap setMapMap(){

        if(total==0){
            total=1;
        }
        if(First==1 || First==0){
            modelMap.put("shangyiye","hidden");
        }else{
            modelMap.put("shangyiye","");
        }
        if(First*5>=total){
            modelMap.put("xiayiye","hidden");
            System.out.println("log......隐藏，隐藏");
        }else {
            modelMap.put("xiayiye","");
            System.out.println("log......不隐藏，不隐藏");
        }

        Float c=Float.valueOf(total)/pagesize;

        int ef= (int) Math.ceil(c);

        startRow= (First-1) * pagesize;;

        if(First>=7 && First+7<=ef){
            a=First-3;
            last=First+2;
            modelMap.put("last","");
            modelMap.put("first","");
        }
        else if(First<7){
            a=0;
            last=8;
            modelMap.put("first","hidden");
            modelMap.put("last","");
        }
        else if(First<=7 && First+7<=ef){
            a=0;
            last=7;
            modelMap.put("first","hidden");
            modelMap.put("last","");
        }else if(First>=7&& First+7>=ef){
            a=ef-7;
            last=ef;
            modelMap.put("first","");
            modelMap.put("last","hidden");
        }

        return modelMap;
    }
    public List yema(){

            List list=new ArrayList();

            for(int q=a;q<last;q++){

            biao biao=new biao();

            biao.setTitle("/ForumControl/"+String.valueOf(q+1));

            biao.setAddress(String.valueOf(q+1));

            if(q+1==First){
                biao.setChecked("active");
            }else {
                biao.setChecked("");
            }

            list.add(biao);
            }
        return list;
    }
}
