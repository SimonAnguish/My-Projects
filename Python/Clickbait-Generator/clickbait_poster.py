#!/usr/bin/python

import urllib
import random

def makeTitle():
	link = "https://en.wikipedia.org/wiki/Special:Random"
	f = urllib.urlopen(link)
	myfile = f.read()
	firstPart = myfile.split('<title>', 1)[1]
	cbSubject = firstPart.split(' - Wikipedia</title>', 1)[0]
	return cbSubject

def makeRand(max=26):
	return random.randint(3, max)

max_pic_count = makeRand()
cbSubject = makeTitle()

buzzthoughts = [" will blow your mind.", " will make you think.", " is unthinkable!", " will shock you."]
buzzword = buzzthoughts[random.randint(0, len(buzzthoughts)-1)]

cbHelpersFirst = ["You'll never believe what ", "Guess what ", str(max_pic_count) + " reasons why you should never trust ", str(max_pic_count) + " surprising uses for ", str(max_pic_count) + " things " + makeTitle() + " could learn from "]
cbHelpersSecond = [" did just before this photo was taken.", " is thinking in these " + str(makeRand(max_pic_count)) + " pictures", ".", ". #" + str(makeRand(max_pic_count)) + buzzword, "."]

rand = random.randint(0, len(cbHelpersFirst)-1)

cbTitle = cbHelpersFirst[rand] + cbSubject + cbHelpersSecond[rand]

print cbTitle
