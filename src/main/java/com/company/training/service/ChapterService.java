package com.company.training.service;

import com.company.training.entity.Chapter;
import com.company.training.entity.Course;
import java.util.List;

public interface ChapterService {
    List<Chapter> getChapterList(Long courseId);

    boolean saveChapter(Chapter chapter);

    boolean updateChapter(Chapter chapter);

    boolean deleteChapter(Long id);

    boolean batchSaveChapters(List<Chapter> chapters);

    Course getCourseInfo(Long courseId);

    Chapter getChapterById(Long id);

    List<Chapter> getAllChapters();

}
