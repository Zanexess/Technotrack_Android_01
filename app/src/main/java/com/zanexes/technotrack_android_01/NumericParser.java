package com.zanexes.technotrack_android_01;
import android.content.Context;

import java.util.Stack;

// Источник - https://mtaalamu.ru/blog/coding/2284.html
// Достаточно сильно поправлен блок логики.
// Удалены всяческие упоминание о валютах.
// Исправлены ошибки связанные с десятками
// Изменены названия

public class NumericParser {

    private  Context context;

    private static enum Ranges {
        UNITS, DECADES, HUNDREDS, THOUSANDS, MILLIONS, BILLIONS
    };

    private static Stack<ThreeChar> threeChars;

    private static class ThreeChar {
        char h, d, u;
        Ranges range;
    }

    public static String digits2text(Integer d, Context context) {
        String s = d.toString();
        if (d < 0 || d > 1000000) {
            return null;
        }

        threeChars = new Stack<>();
        threeChars.push(new ThreeChar());
        threeChars.peek().range = Ranges.UNITS;
        StringBuilder sb = new StringBuilder(s).reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                threeChars.push(new ThreeChar());
            }
            ThreeChar threeChar = threeChars.peek();
            switch (i) {
                case 0:
                    threeChar.u = sb.charAt(i);
                    break;
                case 3:
                    threeChar.range = Ranges.THOUSANDS;
                    threeChar.u = sb.charAt(i);
                    break;
                case 6:
                    threeChar.range = Ranges.MILLIONS;
                    threeChar.u = sb.charAt(i);
                    break;
                case 2:
                case 5:
                case 8:
                    threeChar.h = sb.charAt(i);
                    break;
                default:
                    threeChar.d = sb.charAt(i);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!threeChars.isEmpty()) {
            ThreeChar thch = threeChars.pop();
            if(thch.h == '0' && thch.d == '0' && thch.u == '0' && !threeChars.isEmpty()) continue;
            if (thch.h > 0) {
                result.append(getHundreds(thch.h, context));
                result.append(' ');
            }
            if (thch.d > '0') {
                if (thch.d > '1' || (thch.d == '1' && thch.u == '0')) {
                    result.append(getDecades(thch.d, context));
                } else if (thch.d > '0') {
                    result.append(getTeens(thch.u, context));
                }
                result.append(' ');
            }
            if (thch.u > '0' && thch.d != '1') {
                result.append(getUnits(thch.u, thch.range == Ranges.THOUSANDS, context));
                result.append(' ');
            }
            switch (thch.range) {
                case MILLIONS:
                    if (thch.d == '1' || thch.u == '0') {
                        result.append(context.getResources().getString(R.string.million1));
                    } else if (thch.u > '4') {
                        result.append(context.getResources().getString(R.string.million1));
                    } else if (thch.u > '1') {
                        result.append(context.getResources().getString(R.string.million2));
                    } else {
                        result.append(context.getResources().getString(R.string.million3));
                    }
                    break;
                case THOUSANDS:
                    if (thch.d == '1' || thch.u == '0') {
                        result.append(context.getResources().getString(R.string.thousand1));
                    } else if (thch.u > '4') {
                        result.append(context.getResources().getString(R.string.thousand1));
                    } else if (thch.u > '1') {
                        result.append(context.getResources().getString(R.string.thousand2));
                    } else {
                        result.append(context.getResources().getString(R.string.thousand3));
                    }
                    break;
            }
            result.append(' ');
        }
        char first = Character.toUpperCase(result.charAt(0));
        result.setCharAt(0, first);
        return result.toString().replaceAll("null", "");
    }

    private static String getHundreds(char digit, Context context) {
        switch (digit) {
            case '1':
                return context.getResources().getString(R.string.hundred1);
            case '2':
                return context.getResources().getString(R.string.hundred2);
            case '3':
                return context.getResources().getString(R.string.hundred3);
            case '4':
                return context.getResources().getString(R.string.hundred4);
            case '5':
                return context.getResources().getString(R.string.hundred5);
            case '6':
                return context.getResources().getString(R.string.hundred6);
            case '7':
                return context.getResources().getString(R.string.hundred7);
            case '8':
                return context.getResources().getString(R.string.hundred8);
            case '9':
                return context.getResources().getString(R.string.hundred9);
            default:
                return null;
        }
    }

    private static String getDecades(char digit, Context context) {
        switch (digit) {
            case '1':
                return context.getResources().getString(R.string.decades1);
            case '2':
                return context.getResources().getString(R.string.decades2);
            case '3':
                return context.getResources().getString(R.string.decades3);
            case '4':
                return context.getResources().getString(R.string.decades4);
            case '5':
                return context.getResources().getString(R.string.decades5);
            case '6':
                return context.getResources().getString(R.string.decades6);
            case '7':
                return context.getResources().getString(R.string.decades7);
            case '8':
                return context.getResources().getString(R.string.decades8);
            case '9':
                return context.getResources().getString(R.string.decades9);
            default:
                return null;
        }
    }

    private static String getUnits(char dig, boolean female, Context context) {
        switch (dig) {
            case '1':
                return female ? context.getResources().getString(R.string.units1_1) : context.getResources().getString(R.string.units1_2);
            case '2':
                return female ? context.getResources().getString(R.string.units2_1) : context.getResources().getString(R.string.units2_2);
            case '3':
                return context.getResources().getString(R.string.units3);
            case '4':
                return context.getResources().getString(R.string.units4);
            case '5':
                return context.getResources().getString(R.string.units5);
            case '6':
                return context.getResources().getString(R.string.units6);
            case '7':
                return context.getResources().getString(R.string.units7);
            case '8':
                return context.getResources().getString(R.string.units8);
            case '9':
                return context.getResources().getString(R.string.units9);
            default:
                return null;
        }
    }

    private static String getTeens(char digit, Context context) {
        String s = "";
        switch (digit) {
            case '1':
                s = context.getResources().getString(R.string.teens1);
                break;
            case '2':
                s = context.getResources().getString(R.string.teens2);
                break;
            case '3':
                s = context.getResources().getString(R.string.teens3);
                break;
            case '4':
                s = context.getResources().getString(R.string.teens4);
                break;
            case '5':
                s = context.getResources().getString(R.string.teens5);
                break;
            case '6':
                s = context.getResources().getString(R.string.teens6);
                break;
            case '7':
                s = context.getResources().getString(R.string.teens7);
                break;
            case '8':
                s = context.getResources().getString(R.string.teens8);
                break;
            case '9':
                s = context.getResources().getString(R.string.teens9);
                break;
        }
        return s + context.getResources().getString(R.string.teens0);
    }
}