package com.company.training.service.impl;

import com.company.training.entity.Chapter;
import com.company.training.entity.Course;
import com.company.training.mapper.ChapterMapper;
import com.company.training.service.ChapterService;
import com.company.training.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private CourseService courseService;

    @Override
    public List<Chapter> getChapterList(Long courseId) {
        return chapterMapper.selectByCourseId(courseId);
    }

    @Override
    public List<Chapter> getAllChapters() {
        return chapterMapper.selectAll();
    }

    // ChapterServiceImpl.java
    @Override
    public Course getCourseInfo(Long courseId) {
        return courseService.getCourseById(courseId); // 调用课程服务获取课程信息
    }

    @Override
    @Transactional
    public boolean saveChapter(Chapter chapter) {
        if (chapter.getId() == null) {
            // 新增章节
            int affected = chapterMapper.insert(chapter);
            if (affected > 0) {
                // 更新课程的章节数
                courseService.updateChapterNum(chapter.getCouId(), 1);
                return true;
            }
        } else {
            // 更新章节
            return chapterMapper.updateByPrimaryKey(chapter) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateChapter(Chapter chapter) {
        return chapterMapper.updateByPrimaryKey(chapter) > 0;
    }


    @Override
    @Transactional
    public boolean deleteChapter(Long id) {
        Chapter chapter = chapterMapper.selectByPrimaryKey(id);
        if (chapter != null) {
            int affected = chapterMapper.deleteByPrimaryKey(id);
            if (affected > 0) {
                // 更新课程的章节数
                courseService.updateChapterNum(chapter.getCouId(), -1);
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean batchSaveChapters(List<Chapter> chapters) {
        if (chapters == null || chapters.isEmpty()) {
            return false;
        }

        // 先删除原有章节
        Long courseId = chapters.get(0).getCouId();
        chapterMapper.deleteByCourseId(courseId);

        // 批量插入新章节
        chapters.forEach(chapter -> {
            chapter.setId(null); // 确保新增
            chapterMapper.insert(chapter);
        });

        // 更新课程章节数
        courseService.updateChapterNum(courseId, chapters.size());
        return true;
    }

    // 在ChapterServiceImpl中实现方法
    @Override
    public Chapter getChapterById(Long id) {
        return chapterMapper.selectByPrimaryKey(id);
    }
}