package com.Maker.service;

import com.Maker.model.Illness;

import java.util.List;

public interface IllnessService {

    Illness addIllness(Illness illness);
    Illness getIllness(String username);
    Illness getIllness(int id);
    List<Illness> getAllIllness();
}
