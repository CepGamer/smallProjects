import kotlin.math.max

fun main() {
    runTest(arrayOf(intArrayOf(5, 4), intArrayOf(6, 4), intArrayOf(6, 7), intArrayOf(2, 3)), 3)
    runTest(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(2, 3)), 2)
    runTest(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1)), 1)
    runTest(arrayOf(intArrayOf(5, 1), intArrayOf(4, 10), intArrayOf(3, 2), intArrayOf(1, 1)), 3)
    runTest(arrayOf(intArrayOf(856, 533),intArrayOf(583, 772),intArrayOf(980, 524),intArrayOf(203, 666),intArrayOf(987, 151),intArrayOf(274, 802),intArrayOf(982, 85),intArrayOf(359, 160),intArrayOf(58, 823),intArrayOf(512, 381),intArrayOf(796, 655),intArrayOf(341, 427),intArrayOf(145, 114),intArrayOf(76, 306),intArrayOf(760, 929),intArrayOf(836, 751),intArrayOf(922, 678),intArrayOf(128, 317),intArrayOf(185, 953),intArrayOf(115, 845),intArrayOf(829, 991),intArrayOf(93, 694),intArrayOf(317, 434),intArrayOf(818, 571),intArrayOf(352, 638),intArrayOf(926, 780),intArrayOf(819, 995),intArrayOf(54, 69),intArrayOf(191, 392),intArrayOf(377, 180),intArrayOf(669, 952),intArrayOf(588, 920),intArrayOf(335, 316),intArrayOf(48, 769),intArrayOf(188, 661),intArrayOf(916, 933),intArrayOf(674, 308),intArrayOf(356, 556),intArrayOf(350, 249),intArrayOf(686, 851),intArrayOf(600, 178),intArrayOf(849, 439),intArrayOf(597, 181),intArrayOf(80, 382),intArrayOf(647, 105),intArrayOf(4, 836),intArrayOf(901, 907),intArrayOf(595, 347),intArrayOf(214, 335),intArrayOf(956, 382),intArrayOf(77, 979),intArrayOf(489, 365),intArrayOf(80, 220),intArrayOf(859, 270),intArrayOf(676, 665),intArrayOf(636, 46),intArrayOf(906, 457),intArrayOf(522, 769),intArrayOf(2, 758),intArrayOf(206, 586),intArrayOf(444, 904),intArrayOf(912, 370),intArrayOf(64, 871),intArrayOf(59, 409),intArrayOf(599, 238),intArrayOf(437, 58),intArrayOf(309, 767),intArrayOf(258, 440),intArrayOf(922, 369),intArrayOf(848, 650),intArrayOf(478, 76),intArrayOf(84, 704),intArrayOf(314, 207),intArrayOf(138, 823),intArrayOf(994, 764),intArrayOf(604, 595),intArrayOf(537, 876),intArrayOf(877, 253),intArrayOf(945, 185),intArrayOf(623, 497),intArrayOf(968, 633),intArrayOf(172, 705),intArrayOf(577, 388),intArrayOf(819, 763),intArrayOf(409, 905),intArrayOf(275, 532),intArrayOf(729, 593),intArrayOf(547, 226),intArrayOf(445, 495),intArrayOf(398, 544),intArrayOf(243, 500),intArrayOf(308, 24),intArrayOf(652, 452),intArrayOf(93, 885),intArrayOf(75, 884),intArrayOf(243, 113),intArrayOf(600, 555),intArrayOf(756, 596),intArrayOf(892, 762),intArrayOf(402, 653),intArrayOf(916, 975),intArrayOf(770, 220),intArrayOf(455, 579),intArrayOf(889, 68),intArrayOf(306, 899),intArrayOf(567, 290),intArrayOf(809, 653),intArrayOf(92, 329),intArrayOf(370, 861),intArrayOf(632, 754),intArrayOf(321, 689),intArrayOf(190, 812),intArrayOf(88, 701),intArrayOf(79, 310),intArrayOf(917, 91),intArrayOf(751, 480),intArrayOf(750, 39),intArrayOf(781, 978),intArrayOf(778, 912),intArrayOf(946, 559),intArrayOf(529, 621),intArrayOf(55, 295),intArrayOf(473, 748),intArrayOf(646, 854),intArrayOf(930, 913),intArrayOf(116, 734),intArrayOf(647, 812),intArrayOf(426, 172),intArrayOf(122, 14),intArrayOf(522, 843),intArrayOf(88, 308),intArrayOf(719, 602),intArrayOf(712, 928),intArrayOf(303, 890),intArrayOf(973, 886),intArrayOf(276, 354),intArrayOf(660, 720),intArrayOf(708, 387),intArrayOf(776, 605),intArrayOf(653, 815),intArrayOf(448, 285),intArrayOf(549, 959),intArrayOf(139, 365),intArrayOf(74, 952),intArrayOf(372, 424),intArrayOf(642, 504),intArrayOf(361, 901),intArrayOf(620, 612),intArrayOf(313, 301),intArrayOf(397, 225),intArrayOf(446, 716),intArrayOf(17, 361),intArrayOf(160, 812),intArrayOf(171, 529),intArrayOf(180, 482),intArrayOf(454, 600),intArrayOf(228, 872),intArrayOf(204, 492),intArrayOf(607, 889),intArrayOf(86, 79),intArrayOf(494, 78),intArrayOf(442, 404),intArrayOf(462, 127),intArrayOf(935, 402),intArrayOf(509, 649),intArrayOf(458, 941),intArrayOf(219, 444),intArrayOf(306, 57),intArrayOf(674, 617),intArrayOf(79, 652),intArrayOf(73, 735),intArrayOf(900, 756),intArrayOf(649, 294),intArrayOf(982, 754),intArrayOf(521, 439),intArrayOf(356, 265),intArrayOf(240, 533),intArrayOf(865, 44),intArrayOf(744, 379),intArrayOf(97, 454),intArrayOf(65, 480),intArrayOf(544, 191),intArrayOf(18, 191),intArrayOf(503, 38),intArrayOf(696, 658),intArrayOf(61, 884),intArrayOf(793, 984),intArrayOf(383, 364),intArrayOf(280, 467),intArrayOf(888, 662),intArrayOf(133, 643),intArrayOf(365, 512),intArrayOf(610, 975),intArrayOf(98, 584),intArrayOf(40, 177),intArrayOf(548, 102),intArrayOf(80, 98),intArrayOf(986, 951),intArrayOf(264, 258),intArrayOf(583, 734),intArrayOf(353, 322),intArrayOf(427, 551),intArrayOf(80, 660),intArrayOf(273, 609),intArrayOf(980, 871),intArrayOf(739, 802),intArrayOf(366, 836),intArrayOf(55, 509),intArrayOf(889, 720),intArrayOf(857, 661),intArrayOf(48, 489),intArrayOf(119, 26),intArrayOf(31, 180),intArrayOf(472, 673),intArrayOf(960, 951),intArrayOf(383, 500),intArrayOf(928, 351),intArrayOf(848, 705),intArrayOf(969, 766),intArrayOf(311, 714),intArrayOf(861, 230),intArrayOf(34, 596),intArrayOf(38, 642),intArrayOf(1, 955),intArrayOf(698, 846),intArrayOf(784, 791),intArrayOf(760, 344),intArrayOf(677, 239),intArrayOf(969, 191),intArrayOf(539, 644),intArrayOf(470, 418),intArrayOf(289, 357),intArrayOf(269, 446),intArrayOf(668, 245),intArrayOf(293, 719),intArrayOf(937, 103),intArrayOf(575, 297),intArrayOf(874, 656),intArrayOf(714, 257),intArrayOf(934, 396),intArrayOf(109, 904),intArrayOf(89, 635),intArrayOf(374, 545),intArrayOf(316, 587),intArrayOf(158, 121),intArrayOf(901, 969),intArrayOf(284, 564),intArrayOf(666, 568),intArrayOf(993, 409),intArrayOf(370, 637),intArrayOf(443, 694),intArrayOf(576, 160),intArrayOf(262, 357),intArrayOf(590, 729),intArrayOf(194, 976),intArrayOf(743, 376),intArrayOf(348, 80),intArrayOf(669, 527),intArrayOf(338, 953),intArrayOf(236, 785),intArrayOf(144, 460),intArrayOf(438, 457),intArrayOf(517, 951),intArrayOf(545, 647),intArrayOf(158, 556),intArrayOf(905, 591),intArrayOf(793, 609),intArrayOf(571, 643),intArrayOf(9, 850),intArrayOf(581, 490),intArrayOf(804, 394),intArrayOf(635, 483),intArrayOf(457, 30),intArrayOf(42, 621),intArrayOf(65, 137),intArrayOf(424, 864),intArrayOf(536, 455),intArrayOf(59, 492),intArrayOf(645, 734),intArrayOf(892, 571),intArrayOf(762, 593),intArrayOf(608, 384),intArrayOf(558, 257),intArrayOf(692, 420),intArrayOf(973, 203),intArrayOf(531, 51),intArrayOf(349, 861),intArrayOf(804, 649),intArrayOf(3, 611),intArrayOf(6, 468),intArrayOf(298, 568),intArrayOf(651, 767),intArrayOf(251, 142),intArrayOf(173, 974),intArrayOf(117, 728),intArrayOf(326, 562),intArrayOf(894, 288),intArrayOf(814, 555),intArrayOf(420, 771),intArrayOf(20, 775),intArrayOf(445, 247),intArrayOf(243, 592),intArrayOf(186, 173),intArrayOf(101, 800),intArrayOf(590, 876),intArrayOf(515, 534),intArrayOf(73, 540),intArrayOf(333, 215),intArrayOf(902, 394),intArrayOf(640, 787),intArrayOf(596, 298),intArrayOf(984, 712),intArrayOf(307, 378),intArrayOf(540, 646),intArrayOf(473, 743),intArrayOf(340, 387),intArrayOf(756, 217),intArrayOf(139, 493),intArrayOf(9, 742),intArrayOf(195, 25),intArrayOf(763, 823),intArrayOf(451, 693),intArrayOf(24, 298),intArrayOf(645, 595),intArrayOf(224, 770),intArrayOf(976, 41),intArrayOf(832, 78),intArrayOf(599, 705),intArrayOf(487, 734),intArrayOf(818, 134),intArrayOf(225, 431),intArrayOf(380, 566),intArrayOf(395, 680),intArrayOf(294, 320),intArrayOf(915, 201),intArrayOf(553, 480),intArrayOf(318, 42),intArrayOf(627, 94),intArrayOf(164, 959),intArrayOf(92, 715),intArrayOf(588, 689),intArrayOf(734, 983),intArrayOf(976, 334),intArrayOf(846, 573),intArrayOf(676, 521),intArrayOf(449, 69),intArrayOf(745, 810),intArrayOf(961, 722),intArrayOf(416, 409),intArrayOf(135, 406),intArrayOf(234, 357),intArrayOf(873, 61),intArrayOf(20, 521),intArrayOf(525, 31),intArrayOf(659, 688),intArrayOf(424, 554),intArrayOf(203, 315),intArrayOf(16, 240),intArrayOf(288, 273),intArrayOf(281, 623),intArrayOf(651, 659),intArrayOf(939, 32),intArrayOf(732, 373),intArrayOf(778, 728),intArrayOf(340, 432),intArrayOf(335, 80),intArrayOf(33, 835),intArrayOf(835, 651),intArrayOf(317, 156),intArrayOf(284, 119),intArrayOf(543, 159),intArrayOf(719, 820),intArrayOf(961, 424),intArrayOf(88, 178),intArrayOf(621, 146),intArrayOf(594, 649),intArrayOf(659, 433),intArrayOf(527, 441),intArrayOf(118, 160),intArrayOf(92, 217),intArrayOf(489, 38),intArrayOf(18, 359),intArrayOf(833, 136),intArrayOf(470, 897),intArrayOf(106, 123),intArrayOf(831, 674),intArrayOf(181, 191),intArrayOf(892, 780),intArrayOf(377, 779),intArrayOf(608, 618),intArrayOf(618, 423),intArrayOf(180, 323),intArrayOf(390, 803),intArrayOf(562, 412),intArrayOf(107, 905),intArrayOf(902, 281),intArrayOf(718, 540),intArrayOf(16, 966),intArrayOf(678, 455),intArrayOf(597, 135),intArrayOf(840, 7),intArrayOf(886, 45),intArrayOf(719, 937),intArrayOf(890, 173)), 5)


    val sln = {Solution()}
    asrt(sln().lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)), 4)
    asrt(sln().lengthOfLIS(intArrayOf(6,6,6,6,6,6)), 1)
    asrt(sln().lengthOfLIS(intArrayOf(0,1,0,4,3,2,3)), 4)
}

fun runTest(input: Array<IntArray>, result: Int) {
    val sln = Solution()

    asrt(sln.maxEnvelopes(input), result)
}

fun asrt(b: Boolean) {
    if (!b) throw java.lang.AssertionError("Failed")
}

fun asrt(a: Int, b: Int) {
    if (a != b) throw AssertionError("Failed: $a got, $b expected")
}

class Solution {
    var envelopes: Array<IntArray> = arrayOf()

    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortByDescending { it[0] * 10_001 + it[1] }

        this.envelopes = envelopes

        return (envelopes.indices).map { findMostThatFit(it) }.max() ?: 0
    }

    fun findMostThatFit(index: Int): Int {
        if (index >= envelopes.size) {
            return 0
        }

        val cur = envelopes[index]
        var maxRes = 1
        for (i in (index + 1) until envelopes.size) {
            val smol = envelopes[i]
            if (cur[0] > smol[0] && cur[1] > smol[1]) {
                maxRes = max(maxRes, findMostThatFit(i) + 1)
            }
        }

        return maxRes
    }

    fun lengthOfLIS(nums: IntArray): Int {
        val nextBigger = IntArray(nums.size) { -1 }

        for (i in nums.indices) {
            val a = nums[i]
            for (j in (i + 1) until nums.size) {
                if (nums[j] > a) {
                    nextBigger
                }
            }
        }

        return 15
    }
}
