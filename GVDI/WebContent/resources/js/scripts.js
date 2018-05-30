function verificar(xhr, status, args, dlg, tb) {
        if(args.validationFailed) {
            PF(dlg).jq.effect("bounce", {times:10}, 100);
        }
        else {
            PF(dlg).hide();
            PF(tb).clearFilters();
            
        }
    }