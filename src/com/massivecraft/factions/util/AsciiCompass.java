package com.massivecraft.factions.util;

import java.util.ArrayList;

import cn.nukkit.utils.TextFormat;

public class AsciiCompass {
    public static AsciiCompass.Point getCompassPointForDirection(double inDegrees) {
        double degrees = (inDegrees - 180) % 360;
        if (degrees < 0)
            degrees += 360;

        if (0 <= degrees && degrees < 22.5)
            return AsciiCompass.Point.N;
        else if (22.5 <= degrees && degrees < 67.5)
            return AsciiCompass.Point.NE;
        else if (67.5 <= degrees && degrees < 112.5)
            return AsciiCompass.Point.E;
        else if (112.5 <= degrees && degrees < 157.5)
            return AsciiCompass.Point.SE;
        else if (157.5 <= degrees && degrees < 202.5)
            return AsciiCompass.Point.S;
        else if (202.5 <= degrees && degrees < 247.5)
            return AsciiCompass.Point.SW;
        else if (247.5 <= degrees && degrees < 292.5)
            return AsciiCompass.Point.W;
        else if (292.5 <= degrees && degrees < 337.5)
            return AsciiCompass.Point.NW;
        else if (337.5 <= degrees && degrees < 360.0)
            return AsciiCompass.Point.N;
        else
            return null;
    }

    public static ArrayList<String> getAsciiCompass(Point inDegrees, TextFormat red, String colorDefault) {
        ArrayList<String> ret = new ArrayList<String>();
        String row;

        row = "";
        row += Point.NW.toString(Point.NW == inDegrees, red, colorDefault);
        row += Point.N.toString(Point.N == inDegrees, red, colorDefault);
        row += Point.NE.toString(Point.NE == inDegrees, red, colorDefault);
        ret.add(row);

        row = "";
        row += Point.W.toString(Point.W == inDegrees, red, colorDefault);
        row += colorDefault + "+";
        row += Point.E.toString(Point.E == inDegrees, red, colorDefault);
        ret.add(row);

        row = "";
        row += Point.SW.toString(Point.SW == inDegrees, red, colorDefault);
        row += Point.S.toString(Point.S == inDegrees, red, colorDefault);
        row += Point.SE.toString(Point.SE == inDegrees, red, colorDefault);
        ret.add(row);

        return ret;
    }

    public static ArrayList<String> getAsciiCompass(double inDegrees, TextFormat colorActive, String colorDefault) {
        return getAsciiCompass(getCompassPointForDirection(inDegrees), colorActive, colorDefault);
    }
    
    public enum Point {
        N('N'),
        NE('/'),
        E('E'),
        SE('\\'),
        S('S'),
        SW('/'),
        W('W'),
        NW('\\');

        public final char asciiChar;

        private Point(final char asciiChar) {
            this.asciiChar = asciiChar;
        }

        @Override
        public String toString() {
            return String.valueOf(this.asciiChar);
        }

        public String toString(boolean isActive, TextFormat colorActive, String colorDefault) {
            return (isActive ? colorActive : colorDefault) + String.valueOf(this.asciiChar);
        }
    }
}
