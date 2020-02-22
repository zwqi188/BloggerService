package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.WordForm;
import com.blogger.bloggerservice.model.Word;
import com.blogger.bloggerservice.repository.WordReposity;
import com.blogger.bloggerservice.repository.custom.WordReposityCustom;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author admin
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordReposity wordReposity;

    @Autowired
    private WordReposityCustom wordReposityCustom;

    @Override
    public ResultVo queryWord() {
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(wordReposityCustom.findAllWord());
        return resultVo;
    }

    @Override
    public ResultVo publishWord(WordForm form) {
        Word word = new Word();
        word.setMasterId(form.getUserId());
        word.setWordContent(form.getWordContent());
        word.setCreatedAt(new Date());
        word.setUpdatedAt(new Date());
        try {
            wordReposity.save(word);
        } catch (Exception ex) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }
}
