package com.jeluchu.monkx.core.utils

val chapterRequester = """
                var ajax = document.getElementsByClassName('caplist')[0].getAttribute('data-ajax');
                var regex = /\/(\d+)$/;
                var id = ajax.match(regex);
                var episodesArray = [];
                var buttons = document.getElementsByClassName('btn btn-secondary fw-semibold border-0');
                var allCompleted = false;
            
                for (var i = 0; i < buttons.length; i++) {
            
                    $.ajax({
                        type: "POST",
                        url: "https://monoschinos2.com/ajax/caplist/" + id,
                        data: { "_token": token, p: i + 1 },
                        success: function(data) {
                            $('.caplist .loader').remove();
                            console.log(data);
                            var el = data.caps;
                            for (var j = 0; j < el.length; j++) {
                                episodesArray.push(el[j]);
                            }
                            
                            episodesArray.sort(function(a, b) {
                                return a.episode - b.episode;
                            });
                            lazyLoadInstance.update();
                            
                            allCompleted = true;
                        },
                        dataType: "json",
                        async: false
                    });
            
                }
            
                
                while (!allCompleted) {
                    
                }
            
                episodesArray
            """.trimIndent()

val regexRequested = """https://monoschinos2\.com/ajax/caplist/\d+""".toRegex()