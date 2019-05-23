package org.teamwork.jpetstore.persistence.Mapper;


import org.teamwork.jpetstore.domain.extra.Sequence;

public interface SequenceMapper {

    Sequence getSequence(Sequence sequence);

    void updateSequence(Sequence sequence);
}
