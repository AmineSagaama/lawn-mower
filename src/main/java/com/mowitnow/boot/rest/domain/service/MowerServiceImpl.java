package com.mowitnow.boot.rest.domain.service;

import com.mowitnow.boot.rest.domain.repository.MowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by asagaama on 13/11/2016.
 */
@Service("mowerService")
public class MowerServiceImpl implements MowerService {

    private MowerRepository mowerRepository;

    /**
     * @param mowerRepository
     */
    @Autowired
    public MowerServiceImpl(MowerRepository mowerRepository) {
        this.mowerRepository = mowerRepository;
    }


    /**
     * @param payload
     * @return
     * @throws Exception
     */
    @Override
    public Collection<String> process(String payload) throws Exception {
        return mowerRepository.process(payload);
    }
}
