package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.ScoreDAO;
import org.example.vtschool_mps_2526.models.entities.ScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class serviceScore {

    @Autowired
    private ScoreDAO scoreDAO;

    public ScoreEntity save(ScoreEntity score) {
        if (scoreDAO.existsById(score.getId())) {
            return null;
        }
        return scoreDAO.save(score);
    }

    public ScoreEntity update(ScoreEntity score) {
        if(!scoreDAO.existsById(score.getId())) {
            return null;
        }

        ScoreEntity score1 = scoreDAO.findById(score.getId()).get();
        score1.setScore(score.getScore());
        score1.setSubject(score.getSubject());
        score1.setEnrollment(score.getEnrollment());

        return scoreDAO.save(score1);
    }

    public void deleteById(Integer id) {
        if (scoreDAO.existsById(id)) {
            scoreDAO.deleteById(id);
        }
    }
}
