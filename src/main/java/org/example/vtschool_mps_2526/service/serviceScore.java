package org.example.vtschool_mps_2526.service;

import org.example.vtschool_mps_2526.models.dao.ScoreDAO;
import org.example.vtschool_mps_2526.models.dto.ScoreDTO;
import org.example.vtschool_mps_2526.models.entities.ScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class serviceScore {

    @Autowired
    private ScoreDAO scoreDAO;

    public ScoreEntity saveScore(ScoreDTO score) {

        ScoreEntity sc = new ScoreEntity();
        sc.setScore(score.getScore());
        sc.setId(score.getId());
        //sc.setSubject(score.getSubject());
        //sc.setEnrollment(score.getEnrollment());


        return scoreDAO.save(sc);
    }


    public ScoreEntity updateScore(ScoreDTO score) {

        Optional<ScoreEntity> scoreEntity = scoreDAO.findById(score.getId());
        if(scoreEntity.isPresent()) {
            ScoreEntity sc = scoreEntity.get();
            sc.setScore(score.getScore());
            //sc.setSubject(score.getSubject());
            //sc.setEnrollment(score.getEnrollment());

            return scoreDAO.save(sc);
        }

        return null;
    }

    public boolean deleteScoreById(int id) {
        Optional<ScoreEntity> scoreEntity = scoreDAO.findById(id);

        if (scoreEntity.isPresent()) {
            scoreDAO.deleteById(id);
            return true;
        }
        return false;
    }

    public ScoreDTO getScoresById(int id) {
        Optional<ScoreEntity> score = scoreDAO.findById(id);

        if (score.isPresent()) {
            ScoreEntity scoreEntity = score.get();
            ScoreDTO scoreDTO = new ScoreDTO();
            scoreDTO.setId(scoreEntity.getId());
            scoreDTO.setScore(scoreEntity.getScore());
            return scoreDTO;
        }
        return null;
    }

    public List<ScoreDTO> getScores() {
       List<ScoreDTO> scoreList = new ArrayList<>();

       for(ScoreEntity scoreEntity : scoreDAO.findAll()) {
           ScoreDTO scoreDTO = new ScoreDTO();
           scoreDTO.setId(scoreEntity.getId());
           scoreDTO.setScore(scoreEntity.getScore());

           scoreList.add(scoreDTO);
       }
       return scoreList;
    }
}
