package com.massivecraft.factions.iface;

import com.massivecraft.factions.struct.Relation;

import cn.nukkit.utils.TextFormat;

public interface RelationParticipator {
    public String describeTo(RelationParticipator that);

    public String describeTo(RelationParticipator that, boolean ucfirst);

    public Relation getRelationTo(RelationParticipator that);

    public Relation getRelationTo(RelationParticipator that, boolean ignorePeaceful);

    public TextFormat getColorTo(RelationParticipator to);
}
