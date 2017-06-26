package br.com.crescer.exerciciosaula4;

import javax.persistence.Entity;

/**
 * @author Mirela
 */
public class VideoDao extends AbstractDao<Video, Long>{
    public VideoDao(Class<Entity> entity) {
        super(Video.class);
    }
}
