$(document).ready(function() {
	
	function ajaxCall() {
		var value = $('#search').val();
		$(".container").empty();
		$.get("dict", {
			"q" : value
		}).done(function(data) {
			if (data.length == 0 && value) {
				 Materialize.toast('Sorry! No matches found. Search different word.', 1000);
			}
			$.each(data, function(index, value) {
				$(".container").append(`
					<div class="col s12">
						<div class="card-panel hoverable blue-grey darken-3">
							<span class="white-text"> ${++index}. (${value.wordtype}) :: ${value.definition}</span>
						</div>
					</div>
				`);
				
			})
		}).fail(function() {
			console.log("error");
		});
	}
	
	
	$("#search").keyup(function(e) {
		ajaxCall();
	});	
	
	$(document).keypress(function(e) {
		if (e.which == 13) {
			e.preventDefault();
			ajaxCall();
		}
	});
});