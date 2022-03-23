package org.daughter.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.daughter.base.dao.ArticleDAO;
import org.daughter.base.dao.SplitDAO;
import org.daughter.base.dao.sources.UpdateParamBase;
import org.daughter.base.model.Article;
import org.daughter.base.model.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@RestController
@RequestMapping("/issue")
public class ArticleIssueController {

    @Autowired
    @Qualifier("ArticleDAO")
    private ArticleDAO articleDAO;

    @Autowired
    @Qualifier("SplitDAO")
    private SplitDAO splitDAO;

    private String path;



    @RequestMapping("/upload-img")
    public FileVO articleIssueController(@RequestParam("file") MultipartFile file) {

        System.out.println( "multipartFile=" + file );
        FileVO fileVO = new FileVO();
        UUID uuid = UUID.randomUUID();
        String fileName = System.currentTimeMillis() + uuid.toString() + file.getOriginalFilename();
        String path = UpdateParamBase.wangEditorURL;
        File filenew = new File( path, fileName );
        try {
            file.transferTo( filenew );
            fileVO.setErrno( 0 );
            String[] values = {"/editorimages/" + fileName};
            fileVO.setData( values );
            System.out.println( JSON.toJSONString(fileVO));

        } catch (IOException e) {
            e.printStackTrace();
        }

//        JSONArray jsonArray = new JSONArray();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put( "errno" , 0 );
//        jsonArray.add( "/editorimages/" + fileName );
//        jsonObject.put( "data" , jsonArray);
//        System.out.println(jsonObject.toJSONString());
//        return jsonObject.toJSONString();
        return fileVO;
    }
}
