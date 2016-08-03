package RGS_timer;

import RGS.*;
import RGS_history.*;
import external.*;

feature package mpfeatures
{
	features:RGS_timerfeature,RGS_historyfeature,RGSfeature;
	straightPrecedence(RGS_timerfeature,RGS_historyfeature,RGSfeature);
}