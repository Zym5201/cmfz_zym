package com.baizhi.controller;
import com.baizhi.entity.Section;
import com.baizhi.service.SectionService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("section")
public class SectionController {
    @Resource(name = "sectionServiceImpl")
    private SectionService sectionService;

    @RequestMapping("insert")
    public @ResponseBody Map<String, Object> save(Section section, MultipartFile file, HttpServletRequest request) {
        System.out.println("---------------------------------------12");
        Map<String, Object> map = new HashMap<String, Object>();
        String fileName = file.getOriginalFilename();
        String type = file.getContentType();
        System.out.println("++++++++++++++++++++++++++");
        String realPath = request.getSession().getServletContext().getRealPath("/section_file");
        File f = new File(realPath, fileName);
        section.setPath(fileName);
        section.setRelease_date(new Date());
        System.out.println("--------------------------");
        try {
            file.transferTo(f);

            MP3File fe = (MP3File) AudioFileIO.read(f);
            MP3AudioHeader audioHeader = (MP3AudioHeader) fe.getAudioHeader();
            String trackLength = audioHeader.getTrackLengthAsString();
            section.setSe_type(type);
            section.setDuration(trackLength);
            long size = file.getSize();
            String fileSize = null;
            if (size < 1024) {
                fileSize = size + "BT";
            } else if (size < 1048576) {
                fileSize = ((float) size / 1024) + "KB";
            } else if (size < 1073741824) {
                fileSize = ((float) size / 1048576) + "MB";
            } else {
                fileSize = ((float) size / 1073741824) + "GB";
            }
            section.setSize(fileSize);
            sectionService.insert(section);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/delSection")
    public @ResponseBody Map<String,Object> delSection(String id) {
        Map<String, Object> map = new HashMap<String,Object>();
        try {
            sectionService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/download")
    public void download(String fileName, String style,HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/section_file");
        System.out.println(fileName);

        FileInputStream fis = new FileInputStream(new File(realPath,fileName));
        /*设置相应头和相应类型*/
        HttpHeaders headers = new HttpHeaders();
        String file_name = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("audio/mpeg;charset=UTF-8");
        if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {//1.IE浏览器UTF-8
            headers.setContentDispositionFormData("attachment", file_name);
        }else{//2.其他浏览器attachment;filename*=utf-8'zh_cn
            response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + file_name);//重点
        }
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis, os);
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(os);
    }
}