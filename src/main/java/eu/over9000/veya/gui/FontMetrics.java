/*
 * Veya
 * Copyright (C) 2015 s1mpl3x
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package eu.over9000.veya.gui;

public class FontMetrics {
	private static final int[] char_widths = new int[256];

	private static final int CHAR_DEFAULT_WIDTH = 32;
	private static final int CHAR_DEFAULT_HEIGHT = 32;

	public static float getCharHeight() {
		return 1f;
	}

	public static float getCharWidth(final int character) {
		if (character < 0 || character >= 256) {
			return 1;
		}
		return ((float) char_widths[character]) / ((float) CHAR_DEFAULT_WIDTH);
	}

	static {
		char_widths[0] = 14;
		char_widths[1] = 14;
		char_widths[2] = 14;
		char_widths[3] = 14;
		char_widths[4] = 14;
		char_widths[5] = 14;
		char_widths[6] = 14;
		char_widths[7] = 14;
		char_widths[8] = 14;
		char_widths[9] = 14;
		char_widths[10] = 14;
		char_widths[11] = 14;
		char_widths[12] = 14;
		char_widths[13] = 14;
		char_widths[14] = 14;
		char_widths[15] = 14;
		char_widths[16] = 14;
		char_widths[17] = 14;
		char_widths[18] = 14;
		char_widths[19] = 14;
		char_widths[20] = 14;
		char_widths[21] = 14;
		char_widths[22] = 14;
		char_widths[23] = 14;
		char_widths[24] = 14;
		char_widths[25] = 14;
		char_widths[26] = 14;
		char_widths[27] = 14;
		char_widths[28] = 14;
		char_widths[29] = 14;
		char_widths[30] = 14;
		char_widths[31] = 14;
		char_widths[32] = 7;
		char_widths[33] = 7;
		char_widths[34] = 9;
		char_widths[35] = 16;
		char_widths[36] = 16;
		char_widths[37] = 21;
		char_widths[38] = 19;
		char_widths[39] = 5;
		char_widths[40] = 7;
		char_widths[41] = 7;
		char_widths[42] = 11;
		char_widths[43] = 16;
		char_widths[44] = 6;
		char_widths[45] = 10;
		char_widths[46] = 6;
		char_widths[47] = 12;
		char_widths[48] = 16;
		char_widths[49] = 16;
		char_widths[50] = 16;
		char_widths[51] = 16;
		char_widths[52] = 16;
		char_widths[53] = 16;
		char_widths[54] = 16;
		char_widths[55] = 16;
		char_widths[56] = 16;
		char_widths[57] = 16;
		char_widths[58] = 6;
		char_widths[59] = 7;
		char_widths[60] = 16;
		char_widths[61] = 16;
		char_widths[62] = 16;
		char_widths[63] = 12;
		char_widths[64] = 22;
		char_widths[65] = 18;
		char_widths[66] = 17;
		char_widths[67] = 18;
		char_widths[68] = 21;
		char_widths[69] = 16;
		char_widths[70] = 15;
		char_widths[71] = 20;
		char_widths[72] = 20;
		char_widths[73] = 7;
		char_widths[74] = 11;
		char_widths[75] = 17;
		char_widths[76] = 14;
		char_widths[77] = 25;
		char_widths[78] = 20;
		char_widths[79] = 21;
		char_widths[80] = 16;
		char_widths[81] = 21;
		char_widths[82] = 16;
		char_widths[83] = 14;
		char_widths[84] = 16;
		char_widths[85] = 20;
		char_widths[86] = 18;
		char_widths[87] = 27;
		char_widths[88] = 17;
		char_widths[89] = 16;
		char_widths[90] = 16;
		char_widths[91] = 8;
		char_widths[92] = 12;
		char_widths[93] = 8;
		char_widths[94] = 16;
		char_widths[95] = 12;
		char_widths[96] = 11;
		char_widths[97] = 13;
		char_widths[98] = 15;
		char_widths[99] = 13;
		char_widths[100] = 15;
		char_widths[101] = 14;
		char_widths[102] = 9;
		char_widths[103] = 14;
		char_widths[104] = 15;
		char_widths[105] = 6;
		char_widths[106] = 6;
		char_widths[107] = 13;
		char_widths[108] = 6;
		char_widths[109] = 22;
		char_widths[110] = 15;
		char_widths[111] = 15;
		char_widths[112] = 15;
		char_widths[113] = 15;
		char_widths[114] = 10;
		char_widths[115] = 11;
		char_widths[116] = 9;
		char_widths[117] = 15;
		char_widths[118] = 14;
		char_widths[119] = 21;
		char_widths[120] = 13;
		char_widths[121] = 14;
		char_widths[122] = 12;
		char_widths[123] = 8;
		char_widths[124] = 6;
		char_widths[125] = 8;
		char_widths[126] = 16;
		char_widths[127] = 14;
		char_widths[128] = 16;
		char_widths[129] = 14;
		char_widths[130] = 6;
		char_widths[131] = 9;
		char_widths[132] = 9;
		char_widths[133] = 20;
		char_widths[134] = 16;
		char_widths[135] = 16;
		char_widths[136] = 11;
		char_widths[137] = 31;
		char_widths[138] = 14;
		char_widths[139] = 7;
		char_widths[140] = 30;
		char_widths[141] = 14;
		char_widths[142] = 16;
		char_widths[143] = 14;
		char_widths[144] = 14;
		char_widths[145] = 6;
		char_widths[146] = 6;
		char_widths[147] = 9;
		char_widths[148] = 9;
		char_widths[149] = 16;
		char_widths[150] = 16;
		char_widths[151] = 21;
		char_widths[152] = 11;
		char_widths[153] = 20;
		char_widths[154] = 11;
		char_widths[155] = 7;
		char_widths[156] = 23;
		char_widths[157] = 14;
		char_widths[158] = 12;
		char_widths[159] = 16;
		char_widths[160] = 7;
		char_widths[161] = 6;
		char_widths[162] = 16;
		char_widths[163] = 16;
		char_widths[164] = 16;
		char_widths[165] = 16;
		char_widths[166] = 7;
		char_widths[167] = 13;
		char_widths[168] = 11;
		char_widths[169] = 23;
		char_widths[170] = 10;
		char_widths[171] = 11;
		char_widths[172] = 16;
		char_widths[173] = 10;
		char_widths[174] = 23;
		char_widths[175] = 11;
		char_widths[176] = 11;
		char_widths[177] = 16;
		char_widths[178] = 9;
		char_widths[179] = 9;
		char_widths[180] = 11;
		char_widths[181] = 17;
		char_widths[182] = 18;
		char_widths[183] = 7;
		char_widths[184] = 11;
		char_widths[185] = 9;
		char_widths[186] = 11;
		char_widths[187] = 11;
		char_widths[188] = 20;
		char_widths[189] = 19;
		char_widths[190] = 20;
		char_widths[191] = 11;
		char_widths[192] = 18;
		char_widths[193] = 18;
		char_widths[194] = 18;
		char_widths[195] = 18;
		char_widths[196] = 18;
		char_widths[197] = 18;
		char_widths[198] = 25;
		char_widths[199] = 18;
		char_widths[200] = 16;
		char_widths[201] = 16;
		char_widths[202] = 16;
		char_widths[203] = 16;
		char_widths[204] = 7;
		char_widths[205] = 7;
		char_widths[206] = 7;
		char_widths[207] = 7;
		char_widths[208] = 21;
		char_widths[209] = 20;
		char_widths[210] = 21;
		char_widths[211] = 21;
		char_widths[212] = 21;
		char_widths[213] = 21;
		char_widths[214] = 21;
		char_widths[215] = 16;
		char_widths[216] = 21;
		char_widths[217] = 20;
		char_widths[218] = 20;
		char_widths[219] = 20;
		char_widths[220] = 20;
		char_widths[221] = 16;
		char_widths[222] = 16;
		char_widths[223] = 15;
		char_widths[224] = 13;
		char_widths[225] = 13;
		char_widths[226] = 13;
		char_widths[227] = 13;
		char_widths[228] = 13;
		char_widths[229] = 13;
		char_widths[230] = 22;
		char_widths[231] = 13;
		char_widths[232] = 14;
		char_widths[233] = 14;
		char_widths[234] = 14;
		char_widths[235] = 14;
		char_widths[236] = 6;
		char_widths[237] = 6;
		char_widths[238] = 6;
		char_widths[239] = 6;
		char_widths[240] = 15;
		char_widths[241] = 15;
		char_widths[242] = 15;
		char_widths[243] = 15;
		char_widths[244] = 15;
		char_widths[245] = 15;
		char_widths[246] = 15;
		char_widths[247] = 16;
		char_widths[248] = 15;
		char_widths[249] = 15;
		char_widths[250] = 15;
		char_widths[251] = 15;
		char_widths[252] = 15;
		char_widths[253] = 14;
		char_widths[254] = 15;
		char_widths[255] = 14;
	}
}